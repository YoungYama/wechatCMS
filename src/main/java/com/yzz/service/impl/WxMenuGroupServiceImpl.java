package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxMenuGroupDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenuGroup;
import com.yzz.service.WxMenuGroupService;
import com.yzz.util.UserOperatedState;

/** 
* 
* @description: WxMenuGroupService接口的实现类WxMenuGroupServiceImpl 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
@Service
public class WxMenuGroupServiceImpl implements WxMenuGroupService {

	@Resource
	WxMenuGroupDao wxMenuGroupDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxMenuGroup entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuGroupDao.insert(entity);
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
	public ResultData<Void> deleteOne(Integer wxMenuGroupId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuGroupDao.deleteByPrimaryKey(wxMenuGroupId);
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
	public ResultData<Void> deleteBatch(Integer[] wxMenuGroupIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuGroupDao.deleteBatch(Arrays.asList(wxMenuGroupIds));
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
	public ResultData<Void> updateOne(WxMenuGroup entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuGroupDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxMenuGroup entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuGroupDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxMenuGroup> selectOne(Integer wxMenuGroupId) {
		ResultData<WxMenuGroup> resultData = new ResultData<>();

		WxMenuGroup wxMenuGroup = wxMenuGroupDao.selectByPrimaryKey(wxMenuGroupId);
		if (wxMenuGroup == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxMenuGroup);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxMenuGroup>> selectList(WxMenuGroup entity, Page page) {
		ResultData<List<WxMenuGroup>> resultData = new ResultData<>();

		List<WxMenuGroup> wxMenuGroups = new ArrayList<>();
		int count = wxMenuGroupDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxMenuGroups = wxMenuGroupDao.selectByEntityAndPage(entity, page);

			if (wxMenuGroups.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxMenuGroups, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxMenuGroup>> selectAll() {
		ResultData<List<WxMenuGroup>> resultData = new ResultData<>();

		List<WxMenuGroup> wxMenuGroups = wxMenuGroupDao.selectByEntityAndPage(null, null);

		if (wxMenuGroups.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxMenuGroups);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}
