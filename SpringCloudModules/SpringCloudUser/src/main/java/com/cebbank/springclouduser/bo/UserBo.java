package com.cebbank.springclouduser.bo;

import lombok.Data;

import java.util.Date;

@Data
public class UserBo {
    private int id;

    private String userName;

    private String mobile;

    private String operKey;

    private String operNo;

    private String workDeptId;

    private String workDeptName;

    private String subBranchId;

    private String subBranchName;

    private String firstBranchName;

    private String firstBranchId;

    private Date addDate;

    private String description;
}
