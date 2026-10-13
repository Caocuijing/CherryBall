package com.cebbank.springcloudcard.cardInfo.controller;


import com.cebbank.springcloudcard.cardInfo.bo.CardBo;
import com.cebbank.springcloudcard.cardInfo.service.CardInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/card")
@Slf4j
public class CardController {
    @Autowired
    private CardInfoService cardInfoService;
    @PostMapping("/info")
    public CardBo getCardInfo(@RequestBody Map<String, Object> map){
        String mobile = (String) map.get("mobile");
        log.info("根据手机号查询用户名片信息");
        CardBo cardBo = cardInfoService.getCardInfoByMobile(mobile);
        log.info("查询结果：" + cardBo);
        return cardBo;
    }
}
