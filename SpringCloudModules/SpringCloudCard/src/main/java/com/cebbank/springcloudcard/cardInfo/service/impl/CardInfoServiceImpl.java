package com.cebbank.springcloudcard.cardInfo.service.impl;

import com.cebbank.springcloudcard.cardInfo.bo.CardBo;
import com.cebbank.springcloudcard.cardInfo.mapper.CardInfoMapper;
import com.cebbank.springcloudcard.cardInfo.service.CardInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CardInfoServiceImpl implements CardInfoService {
//    private static final Logger log = LoggerFactory.getLogger(CardInfoServiceImpl.class);
//    private static final Log logger = LogFactory.getLog(CardInfoServiceImpl.class);
    @Autowired
    private CardInfoMapper cardInfoMapper;
    @Override
    public CardBo getCardInfoByMobile(String mobile) {
        log.info("当前用户的手机号：" + mobile);
        return cardInfoMapper.getCardInfoByMobile(mobile);
    }
}
