package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxMenuGroup;

/** 
* 
* @description: 实体类WxMenuGroup的DAO接口 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
@Repository
public interface WxMenuGroupDao {

	/**单个实体全部字段添加*/
	int insert(WxMenuGroup entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(Integer wxMenuGroupId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<Integer> wxMenuGroupIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxMenuGroup entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxMenuGroup entity);

	/**根据实体ID查询单个实体*/
	WxMenuGroup selectByPrimaryKey(Integer wxMenuGroupId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxMenuGroup> selectByEntityAndPage(@Param("entity") WxMenuGroup entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxMenuGroup entity);

}
