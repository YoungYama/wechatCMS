package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxText;

/** 
* 
* @description: 实体类WxText的DAO接口 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Repository
public interface WxTextDao {

	/**单个实体全部字段添加*/
	int insert(WxText entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxTextId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxTextIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxText entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxText entity);

	/**根据实体ID查询单个实体*/
	WxText selectByPrimaryKey(String wxTextId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxText> selectByEntityAndPage(@Param("entity") WxText entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxText entity);

}
