package com.peterjxl.learnspringbootwebadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peterjxl.learnspringbootwebadmin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
