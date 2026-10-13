package com.cebbank.springclouduser.controller;


import com.cebbank.springclouduser.bo.UserBo;
import com.cebbank.springclouduser.feign.CardFeignClient;
import com.cebbank.springclouduser.feign.bo.CardBo;
import com.cebbank.springclouduser.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private CardFeignClient cardFeignClient;
    @Value("8082")
    private String port;
    @GetMapping("/{id}")
    public CardBo getUserInfoById(@PathVariable("id") String id) {
        System.err.println("port:" + port);
        UserBo userInfo = userInfoService.getUserInfoByOperKey(id);
        Map<String, Object> map = new HashMap();
        map.put("mobile", userInfo.getMobile());
        CardBo cardInfoByMobile = cardFeignClient.getCardInfoByMobile(map);
        System.err.println("Feign的数据："+cardInfoByMobile);
        System.err.println(userInfo);
        return cardInfoByMobile;
    }

    @PostMapping("/modify")
    public String modify(@RequestBody Map<String, Object> map) {
        String userName = (String) map.get("userName");
        System.out.println("修改后的用户名是：" + userName);
        return userName;
    }


}
