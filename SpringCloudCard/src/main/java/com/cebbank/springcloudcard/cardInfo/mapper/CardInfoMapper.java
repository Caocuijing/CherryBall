package com.cebbank.springcloudcard.cardInfo.mapper;

import com.cebbank.springcloudcard.cardInfo.bo.CardBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardInfoMapper {
    CardBo getCardInfoByMobile(String mobile);
}
