package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxText;

/** 
* 
* @description: 实体类WxText的service接口 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
public interface WxTextService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxText entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(String wxTextId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(String[] wxTextIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxText entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxText entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxText> selectOne(String wxTextId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxText>> selectList(WxText entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxText>> selectAll();

}
