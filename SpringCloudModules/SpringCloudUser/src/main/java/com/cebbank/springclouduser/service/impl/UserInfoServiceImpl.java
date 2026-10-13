package com.cebbank.springclouduser.service.impl;

import com.cebbank.springclouduser.bo.UserBo;
import com.cebbank.springclouduser.mapper.UserInfoMapper;
import com.cebbank.springclouduser.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserBo getUserInfoByOperKey(String userId) {
        log.info("当前用户的userId：" + userId);
        return userInfoMapper.getUserInfoByOperKey(userId);
    }
}
