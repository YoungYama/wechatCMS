package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenu;

/** 
* 
* @description: 实体类WxMenu的service接口 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
public interface WxMenuService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxMenu entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(String wxMenuId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(String[] wxMenuIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxMenu entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxMenu entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxMenu> selectOne(String wxMenuId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxMenu>> selectList(WxMenu entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxMenu>> selectAll();

}
