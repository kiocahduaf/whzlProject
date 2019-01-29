package com.whzl.modules.person.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.whzl.modules.person.entity.PersonEntity;

/**
 * 用户
 * 
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
@Mapper
public interface PersonDao extends BaseMapper<PersonEntity> {

}
