package com.cebbank.springcloudgateway.config;


import com.cebbank.springcloudgateway.fliter.SecurityService;
import com.cebbank.springcloudgateway.fliter.UserCustomerFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor//有参构造
public class RouteConfig {
    private final SecurityService securityService;
    private static final String CARD = "lb://card";
    private static final String USER = "lb://user";
    private static final String LOADER = "lb://loader";

    private final UserCustomerFilter userCustomerFilter;

    @Bean
    public RouteLocator customRouteConfig(RouteLocatorBuilder builder){
        RouteLocator build = builder
                .routes()
                .route("card", r -> r.path("/card/**")
                        .filters(f -> f//.modifyRequestBody(String.class,String.class,(securityService::modifyRequestBody))
                                //.modifyResponseBody(String.class,String.class,(securityService::modifyResponseBody))
                                .filter(userCustomerFilter))
                        .uri(CARD))
                .route("user",r ->r.path("/user/**")
                        .filters(f ->f.modifyResponseBody(String.class,String.class,(securityService::modifyResponseBody))
                                .modifyRequestBody(String.class,String.class,(securityService::modifyRequestBody)))
                        .uri(USER)).build();
        return build;
    }
}
