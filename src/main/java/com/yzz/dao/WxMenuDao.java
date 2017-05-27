package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxMenu;

/** 
* 
* @description: 实体类WxMenu的DAO接口 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
@Repository
public interface WxMenuDao {

	/**单个实体全部字段添加*/
	int insert(WxMenu entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxMenuId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxMenuIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxMenu entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxMenu entity);

	/**根据实体ID查询单个实体*/
	WxMenu selectByPrimaryKey(String wxMenuId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxMenu> selectByEntityAndPage(@Param("entity") WxMenu entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxMenu entity);

}
