package com.cebbank.springclouduser.feign;

import com.cebbank.springclouduser.feign.bo.CardBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value = "card", path = "/card/card")
public interface CardFeignClient {
    @PostMapping("/info")
    CardBo getCardInfoByMobile(@RequestBody Map<String, Object> map);
}
