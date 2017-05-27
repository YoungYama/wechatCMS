package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxMenuDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenu;
import com.yzz.service.WxMenuService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxMenuService接口的实现类WxMenuServiceImpl 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
@Service
public class WxMenuServiceImpl implements WxMenuService {

	@Resource
	WxMenuDao wxMenuDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxMenu entity) {
		ResultData<Void> resultData = new ResultData<>();

		entity.setWxMenuId(IdGenerator.generatesId());
		int rows = wxMenuDao.insert(entity);
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
	public ResultData<Void> deleteOne(String wxMenuId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuDao.deleteByPrimaryKey(wxMenuId);
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
	public ResultData<Void> deleteBatch(String[] wxMenuIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuDao.deleteBatch(Arrays.asList(wxMenuIds));
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
	public ResultData<Void> updateOne(WxMenu entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxMenu entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxMenuDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxMenu> selectOne(String wxMenuId) {
		ResultData<WxMenu> resultData = new ResultData<>();

		WxMenu wxMenu = wxMenuDao.selectByPrimaryKey(wxMenuId);
		if (wxMenu == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxMenu);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxMenu>> selectList(WxMenu entity, Page page) {
		ResultData<List<WxMenu>> resultData = new ResultData<>();

		List<WxMenu> wxMenus = new ArrayList<>();
		int count = wxMenuDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxMenus = wxMenuDao.selectByEntityAndPage(entity, page);

			if (wxMenus.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxMenus, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxMenu>> selectAll() {
		ResultData<List<WxMenu>> resultData = new ResultData<>();

		List<WxMenu> wxMenus = wxMenuDao.selectByEntityAndPage(null, null);

		if (wxMenus.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxMenus);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}
