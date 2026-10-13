package com.cebbank.springcloudgateway.fliter;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Component
@Slf4j
public class UserCustomerFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI uri = exchange.getRequest().getURI();
        log.info("自定义过滤器中的URI是：" + uri);
        exchange.getRequest().getHeaders();
//        exchange.getResponse().getHeaders().add("123","222");
//        exchange.getResponse().getHeaders().set("111","222");
        exchange.getResponse().getHeaders().set("customer","true");
        List<String> operKeys = exchange.getRequest().getHeaders().get("operKey");
        String first = CollUtil.getFirst(operKeys);
        if (!"OP001".equals(first)){
            throw new RuntimeException("当前的OperKey不匹配");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
