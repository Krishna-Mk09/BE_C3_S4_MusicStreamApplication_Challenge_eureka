package com.niit.jdp.springAPIGateWay;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableEurekaClient
public class SpringApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGateWayApplication.class, args);
	}
		@Bean
		public RouteLocator getRoutes(RouteLocatorBuilder builder)
		{
			return builder.routes()
					.route(p->p
							.path("/userservice/**")
							.uri("lb://UserAuthenticate/"))
					.route(p->p
							.path("/api/v1/**")
							.uri("lb://customer-service/"))
					.build();
		}
}
