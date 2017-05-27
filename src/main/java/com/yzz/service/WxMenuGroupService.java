package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenuGroup;

/** 
* 
* @description: 实体类WxMenuGroup的service接口 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
public interface WxMenuGroupService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxMenuGroup entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(Integer wxMenuGroupId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(Integer[] wxMenuGroupIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxMenuGroup entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxMenuGroup entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxMenuGroup> selectOne(Integer wxMenuGroupId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxMenuGroup>> selectList(WxMenuGroup entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxMenuGroup>> selectAll();

}
