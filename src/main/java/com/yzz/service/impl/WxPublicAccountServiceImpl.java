package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.SysUserDao;
import com.yzz.dao.WxPublicAccountDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;
import com.yzz.entity.WxPublicAccount;
import com.yzz.service.WxPublicAccountService;
import com.yzz.util.IdGenerator;
import com.yzz.util.UserOperatedState;

/** 
* 
* @description: WxPublicAccountService接口的实现类WxPublicAccountServiceImpl 
* 
* @author 杨志钊 
* @date 2017-05-27 11:10:57 
*/ 
@Service
public class WxPublicAccountServiceImpl implements WxPublicAccountService {

	@Resource
	WxPublicAccountDao wxPublicAccountDao;
	@Resource
	SysUserDao sysUserDao;

	/**单个实体全部字段添加或者修改*/
	@Override
	public ResultData<Void> saveOne(WxPublicAccount entity, SysUser sysUser) {
		ResultData<Void> resultData = new ResultData<>();

		String wxPublicAccountId = sysUser.getWxPublicAccountId();
		
		if (wxPublicAccountId != null && !wxPublicAccountId.equals("")) {//公众号存在则修改
			int rows = wxPublicAccountDao.updateByPrimaryKeySelective(entity);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.SAVE_ERROR);
			} else {
				resultData.setMsg(UserOperatedState.SAVE_SUCCESS);
			}
		} else {//公众号不存在则添加
			String id  = IdGenerator.generatesId();
			entity.setWxPublicAccountId(id);
			int rows = wxPublicAccountDao.insert(entity);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.SAVE_ERROR);
			} else {
				sysUser.setWxPublicAccountId(id);
				sysUserDao.updateByPrimaryKey(sysUser);//成功则添加微信公众号ID
				resultData.setMsg(UserOperatedState.SAVE_SUCCESS);
			}
		}

		return resultData;
	}
	
	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxPublicAccount entity) {
		ResultData<Void> resultData = new ResultData<>();
		
		entity.setWxPublicAccountId(IdGenerator.generatesId());
		int rows = wxPublicAccountDao.insert(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INSERT_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.INSERT_SUCCESS);
		}
		
		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@Override
	public ResultData<Void> deleteOne(String wxPublicAccountId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxPublicAccountDao.deleteByPrimaryKey(wxPublicAccountId);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.DELETE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
		}

		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@Override
	public ResultData<Void> deleteBatch(String[] wxPublicAccountIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxPublicAccountDao.deleteBatch(Arrays.asList(wxPublicAccountIds));
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.DELETE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
		}

		return resultData;
	}

	/**单个实体全部字段更新*/
	@Override
	public ResultData<Void> updateOne(WxPublicAccount entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxPublicAccountDao.updateByPrimaryKey(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
		}

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@Override
	public ResultData<Void> updateOneSelective(WxPublicAccount entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxPublicAccountDao.updateByPrimaryKeySelective(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
		}

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@Override
	public ResultData<WxPublicAccount> selectOne(String wxPublicAccountId) {
		ResultData<WxPublicAccount> resultData = new ResultData<>();

		WxPublicAccount wxPublicAccount = wxPublicAccountDao.selectByPrimaryKey(wxPublicAccountId);
		if (wxPublicAccount == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxPublicAccount);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxPublicAccount>> selectList(WxPublicAccount entity, Page page) {
		ResultData<List<WxPublicAccount>> resultData = new ResultData<>();

		List<WxPublicAccount> wxPublicAccounts = new ArrayList<>();
		int count = wxPublicAccountDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxPublicAccounts = wxPublicAccountDao.selectByEntityAndPage(entity, page);

			if (wxPublicAccounts.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxPublicAccounts, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxPublicAccount>> selectAll() {
		ResultData<List<WxPublicAccount>> resultData = new ResultData<>();

		List<WxPublicAccount> wxPublicAccounts = wxPublicAccountDao.selectByEntityAndPage(null, null);

		if (wxPublicAccounts.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxPublicAccounts);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}
