package com.cebbank.springcloudcard.cardInfo.service;

import com.cebbank.springcloudcard.cardInfo.bo.CardBo;

public interface CardInfoService {
    CardBo getCardInfoByMobile(String mobile);
}
