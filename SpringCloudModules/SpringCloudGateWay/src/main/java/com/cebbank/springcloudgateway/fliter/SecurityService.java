package com.cebbank.springcloudgateway.fliter;


import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.Charset;
import java.util.Map;

@Component
@Slf4j
public class SecurityService {
    private final SymmetricCrypto sm4 = SmUtil.sm4("cebbank987654321".getBytes());
    /*
    * 修改请求体
    * @param exchange
    * @param s
    * @return
    * */
    public Mono<String> modifyRequestBody(ServerWebExchange exchange,String s){
        log.info("解密之前的数据是:" + s);
        JSONObject entries = JSONUtil.parseObj(s);
        Object value = entries.get("value");
        String s1 = sm4.decryptStr(value.toString(), Charset.defaultCharset());
        exchange.getResponse().getHeaders().set("decrpt","1");
        log.info("解密之后的数据是:" + s1);
        return Mono.just(s1);
    }
//    public Mono<String> modifyRequestBody(ServerWebExchange exchange,String orignBodyStr){
//        log.info("修改前的数据是：" + orignBodyStr);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> map = objectMapper.readValue(orignBodyStr, Map.class);
//        if (map.containsKey("userName") && map.get("userName")!=null){
//            String oldVal = map.get("userName").toString();
//            map.put("userName","cebbank"+oldVal);
//        }
//        String newBodyStr = objectMapper.writeValueAsString(map);
//        log.info("修改后的数据是：" + newBodyStr);
//        return Mono.just(newBodyStr);
//    }
    /*
    * 修改响应体 进行加密操作
    * @param exchange
    * @param s
    * @return s1
    * */
    public Mono<String> modifyResponseBody(ServerWebExchange exchange,String s){
        log.info("加密前的数据是：" + s);
        String s1 = sm4.encryptHex(s.getBytes());
        log.info("加密后的数据是：" + s1);
        exchange.getResponse().getHeaders().set("encode", "true");
        return Mono.just(s1);
    }
}
