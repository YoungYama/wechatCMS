package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxTextDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxText;
import com.yzz.service.WxTextService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxTextService接口的实现类WxTextServiceImpl 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Service
public class WxTextServiceImpl implements WxTextService {

	@Resource
	WxTextDao wxTextDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxText entity) {
		ResultData<Void> resultData = new ResultData<>();

		entity.setWxTextId(IdGenerator.generatesId());
		int rows = wxTextDao.insert(entity);
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
	public ResultData<Void> deleteOne(String wxTextId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxTextDao.deleteByPrimaryKey(wxTextId);
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
	public ResultData<Void> deleteBatch(String[] wxTextIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxTextDao.deleteBatch(Arrays.asList(wxTextIds));
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
	public ResultData<Void> updateOne(WxText entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxTextDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxText entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxTextDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxText> selectOne(String wxTextId) {
		ResultData<WxText> resultData = new ResultData<>();

		WxText wxText = wxTextDao.selectByPrimaryKey(wxTextId);
		if (wxText == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxText);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxText>> selectList(WxText entity, Page page) {
		ResultData<List<WxText>> resultData = new ResultData<>();

		List<WxText> wxTexts = new ArrayList<>();
		int count = wxTextDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxTexts = wxTextDao.selectByEntityAndPage(entity, page);

			if (wxTexts.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxTexts, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxText>> selectAll() {
		ResultData<List<WxText>> resultData = new ResultData<>();

		List<WxText> wxTexts = wxTextDao.selectByEntityAndPage(null, null);

		if (wxTexts.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxTexts);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}
