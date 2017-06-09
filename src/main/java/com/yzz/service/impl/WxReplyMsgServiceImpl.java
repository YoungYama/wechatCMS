package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxReplyMsgDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxReplyMsg;
import com.yzz.service.WxReplyMsgService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxReplyMsgService接口的实现类WxReplyMsgServiceImpl 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Service
public class WxReplyMsgServiceImpl implements WxReplyMsgService {

	@Resource
	WxReplyMsgDao wxReplyMsgDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxReplyMsg entity) {
		ResultData<Void> resultData = new ResultData<>();

		entity.setWxReplyMsgId(IdGenerator.generatesId());
		int rows = wxReplyMsgDao.insert(entity);
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
	public ResultData<Void> deleteOne(String wxReplyMsgId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxReplyMsgDao.deleteByPrimaryKey(wxReplyMsgId);
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
	public ResultData<Void> deleteBatch(String[] wxReplyMsgIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxReplyMsgDao.deleteBatch(Arrays.asList(wxReplyMsgIds));
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
	public ResultData<Void> updateOne(WxReplyMsg entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxReplyMsgDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxReplyMsg entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxReplyMsgDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxReplyMsg> selectOne(String wxReplyMsgId) {
		ResultData<WxReplyMsg> resultData = new ResultData<>();

		WxReplyMsg wxReplyMsg = wxReplyMsgDao.selectByPrimaryKey(wxReplyMsgId);
		if (wxReplyMsg == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxReplyMsg);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxReplyMsg>> selectList(WxReplyMsg entity, Page page) {
		ResultData<List<WxReplyMsg>> resultData = new ResultData<>();

		List<WxReplyMsg> wxReplyMsgs = new ArrayList<>();
		int count = wxReplyMsgDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxReplyMsgs = wxReplyMsgDao.selectByEntityAndPage(entity, page);

			if (wxReplyMsgs.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxReplyMsgs, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxReplyMsg>> selectAll() {
		ResultData<List<WxReplyMsg>> resultData = new ResultData<>();

		List<WxReplyMsg> wxReplyMsgs = wxReplyMsgDao.selectByEntityAndPage(null, null);

		if (wxReplyMsgs.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxReplyMsgs);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}
