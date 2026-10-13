package com.cebbank.springclouduser.service;

import com.cebbank.springclouduser.bo.UserBo;

public interface UserInfoService {
    UserBo getUserInfoByOperKey(String userId);
}
