package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxNews;

/** 
* 
* @description: 实体类WxNews的DAO接口 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Repository
public interface WxNewsDao {

	/**单个实体全部字段添加*/
	int insert(WxNews entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxNewsId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxNewsIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxNews entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxNews entity);

	/**根据实体ID查询单个实体*/
	WxNews selectByPrimaryKey(String wxNewsId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxNews> selectByEntityAndPage(@Param("entity") WxNews entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxNews entity);

}
