package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;
import com.yzz.entity.WxPublicAccount;

/** 
* 
* @description: 实体类WxPublicAccount的service接口 
* 
* @author 杨志钊 
* @date 2017-05-27 11:10:57 
*/ 
public interface WxPublicAccountService {
	
	/**单个实体全部字段添加或者修改*/
	ResultData<Void> saveOne(WxPublicAccount entity, SysUser sysUser);

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxPublicAccount entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(String wxPublicAccountId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(String[] wxPublicAccountIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxPublicAccount entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxPublicAccount entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxPublicAccount> selectOne(String wxPublicAccountId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxPublicAccount>> selectList(WxPublicAccount entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxPublicAccount>> selectAll();

}
