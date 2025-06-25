package com.travelq.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("flight_route", r -> r
                        .path("/travelq/flight/**")
                        .filters(f -> f.rewritePath("/travelq/flight/(?<segment>.*)", "/${segment}")
                                .filter((exchange, chain) -> {
                                    long start = System.currentTimeMillis();
                                    return chain.filter(exchange).then(
                                            Mono.fromRunnable(() -> {
                                                long duration = System.currentTimeMillis() - start;
                                                exchange.getResponse().getHeaders().add("X-Response-Time", duration + "ms");
                                            })
                                    );
                                })
                        )
                        .uri("lb://FLIGHT"))
                .route("user_route", r -> r
                        .path("/travelq/user/**")
                        .filters(f -> f.rewritePath("/travelq/user/(?<segment>.*)", "/${segment}")
                                .filter((exchange, chain) -> {
                                    long start = System.currentTimeMillis();
                                    return chain.filter(exchange).then(
                                            Mono.fromRunnable(() -> {
                                                long duration = System.currentTimeMillis() - start;
                                                exchange.getResponse().getHeaders().add("X-Response-Time", duration + "ms");
                                            })
                                    );
                                })
                        )
                        .uri("lb://USER"))

                .build();
    }
}
