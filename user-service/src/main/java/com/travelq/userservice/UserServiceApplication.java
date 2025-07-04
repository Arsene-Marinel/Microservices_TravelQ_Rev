package com.travelq.userservice;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.travelq.userservice.controller.clients")
public class UserServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// Configure ModelMapper to handle circular references and lazy loading
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STANDARD)
				.setSkipNullEnabled(true)
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

		// Custom condition to skip uninitialized collections
		Condition<Object, Object> skipUninitialized = new Condition<Object, Object>() {
			@Override
			public boolean applies(MappingContext<Object, Object> context) {
				if (context.getSource() instanceof PersistentCollection) {
					return ((PersistentCollection<?>) context.getSource()).wasInitialized();
				}
				return true;
			}
		};

		// Apply the condition to all property mappings
		modelMapper.getConfiguration().setPropertyCondition(skipUninitialized);

		// Add a custom converter for PersistentBag to List
		modelMapper.addConverter(ctx -> {
			if (ctx.getSource() == null) {
				return new ArrayList<>();
			}
			return new ArrayList<>(ctx.getSource());
		}, Collection.class, List.class);

		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
