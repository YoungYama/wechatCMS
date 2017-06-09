package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxText;
import com.yzz.service.WxTextService;

/** 
* 
* @description: 实体类WxText的控制器WxTextCtrl 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Controller
@RequestMapping("/wxText")
public class WxTextCtrl {

	@Resource
	WxTextService wxTextService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxText entity) {
		ResultData<Void> resultData = wxTextService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxTextId) {
		ResultData<Void> resultData = wxTextService.deleteOne(wxTextId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxTextIds) {
		ResultData<Void> resultData = wxTextService.deleteBatch(wxTextIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxText entity) {
		ResultData<Void> resultData = wxTextService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxText entity) {
		ResultData<Void> resultData = wxTextService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxText> selectOne(String wxTextId) {
		ResultData<WxText> resultData = wxTextService.selectOne(wxTextId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxText>> selectList(WxText entity, Page page) {
		ResultData<List<WxText>> resultData = wxTextService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxText>> selectAll() {
		ResultData<List<WxText>> resultData = wxTextService.selectAll();

		return resultData;
	}

}
