package com.cebbank.springclouduser.mapper;

import com.cebbank.springclouduser.bo.UserBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    /*
    * 根据ID查询用户信息
    */
    UserBo getUserInfoByOperKey(String userId);
}
