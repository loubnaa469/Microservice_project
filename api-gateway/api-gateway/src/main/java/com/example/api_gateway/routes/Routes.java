package com.example.api_gateway.routes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class Routes {

    @Value("${client.service.url}")
    private String ClientServiceUrl;
    @Value("${titre.service.url}")
    private String TitreServiceUrl;



    @Bean
    public RouterFunction<ServerResponse> clientServiceRoute() {
        return GatewayRouterFunctions.route("client-service")
                .route(RequestPredicates.path("/clients"), HandlerFunctions.http(ClientServiceUrl))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker("productServiceCircuitBreaker",
                        URI.create("forward:/fallbackRoute")))
                .build();
    }
//
    @Bean
    public RouterFunction<ServerResponse> titreServiceRoute() {
        return GatewayRouterFunctions.route("titre-service")
                .route(RequestPredicates.path("/Titres"), HandlerFunctions.http(TitreServiceUrl))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker("titreServiceCircuitBreaker",
                        URI.create("forward:/fallbackRoute")))
//                .filter(setPath("/api-docs"))
                .build();
    }

}