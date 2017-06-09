package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxReplyMsg;
import com.yzz.service.WxReplyMsgService;

/** 
* 
* @description: 实体类WxReplyMsg的控制器WxReplyMsgCtrl 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Controller
@RequestMapping("/wxReplyMsg")
public class WxReplyMsgCtrl {

	@Resource
	WxReplyMsgService wxReplyMsgService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxReplyMsg entity) {
		ResultData<Void> resultData = wxReplyMsgService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxReplyMsgId) {
		ResultData<Void> resultData = wxReplyMsgService.deleteOne(wxReplyMsgId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxReplyMsgIds) {
		ResultData<Void> resultData = wxReplyMsgService.deleteBatch(wxReplyMsgIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxReplyMsg entity) {
		ResultData<Void> resultData = wxReplyMsgService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxReplyMsg entity) {
		ResultData<Void> resultData = wxReplyMsgService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxReplyMsg> selectOne(String wxReplyMsgId) {
		ResultData<WxReplyMsg> resultData = wxReplyMsgService.selectOne(wxReplyMsgId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxReplyMsg>> selectList(WxReplyMsg entity, Page page) {
		ResultData<List<WxReplyMsg>> resultData = wxReplyMsgService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxReplyMsg>> selectAll() {
		ResultData<List<WxReplyMsg>> resultData = wxReplyMsgService.selectAll();

		return resultData;
	}

}
