package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxNewsDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxNews;
import com.yzz.service.WxNewsService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxNewsService接口的实现类WxNewsServiceImpl 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Service
public class WxNewsServiceImpl implements WxNewsService {

	@Resource
	WxNewsDao wxNewsDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxNews entity) {
		ResultData<Void> resultData = new ResultData<>();

		entity.setWxNewsId(IdGenerator.generatesId());
		int rows = wxNewsDao.insert(entity);
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
	public ResultData<Void> deleteOne(String wxNewsId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxNewsDao.deleteByPrimaryKey(wxNewsId);
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
	public ResultData<Void> deleteBatch(String[] wxNewsIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxNewsDao.deleteBatch(Arrays.asList(wxNewsIds));
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
	public ResultData<Void> updateOne(WxNews entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxNewsDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxNews entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxNewsDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxNews> selectOne(String wxNewsId) {
		ResultData<WxNews> resultData = new ResultData<>();

		WxNews wxNews = wxNewsDao.selectByPrimaryKey(wxNewsId);
		if (wxNews == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxNews);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxNews>> selectList(WxNews entity, Page page) {
		ResultData<List<WxNews>> resultData = new ResultData<>();

		List<WxNews> wxNewss = new ArrayList<>();
		int count = wxNewsDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxNewss = wxNewsDao.selectByEntityAndPage(entity, page);

			if (wxNewss.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxNewss, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxNews>> selectAll() {
		ResultData<List<WxNews>> resultData = new ResultData<>();

		List<WxNews> wxNewss = wxNewsDao.selectByEntityAndPage(null, null);

		if (wxNewss.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxNewss);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}
