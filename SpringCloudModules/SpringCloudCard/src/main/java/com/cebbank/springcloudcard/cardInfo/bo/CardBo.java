package com.cebbank.springcloudcard.cardInfo.bo;

import lombok.Data;

import java.util.Date;

@Data

public class CardBo {
    private int id;

    private String userName;

    private String mobile;

    private String address;

    private String theme;

    private Date addDate;

    private String title;
}
