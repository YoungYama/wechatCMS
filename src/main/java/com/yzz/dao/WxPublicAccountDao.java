package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxPublicAccount;

/** 
* 
* @description: 实体类WxPublicAccount的DAO接口 
* 
* @author 杨志钊 
* @date 2017-05-27 11:10:57 
*/ 
@Repository
public interface WxPublicAccountDao {

	/**单个实体全部字段添加*/
	int insert(WxPublicAccount entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxPublicAccountId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxPublicAccountIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxPublicAccount entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxPublicAccount entity);

	/**根据实体ID查询单个实体*/
	WxPublicAccount selectByPrimaryKey(String wxPublicAccountId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxPublicAccount> selectByEntityAndPage(@Param("entity") WxPublicAccount entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxPublicAccount entity);

}
