package cn.qydx.service.sso.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.qydx.service.sso.model.UserInfo;

@Mapper
@Repository
public interface UserInfoMapper {

    @Select("select * from t_user where usrname = #{name}")
    UserInfo getUserInfoByName(@Param("name") String name);
}
