package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenuGroup;
import com.yzz.service.WxMenuGroupService;

/** 
* 
* @description: 实体类WxMenuGroup的控制器WxMenuGroupCtrl 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
@Controller
@RequestMapping("/wxMenuGroup")
public class WxMenuGroupCtrl {

	@Resource
	WxMenuGroupService wxMenuGroupService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxMenuGroup entity) {
		ResultData<Void> resultData = wxMenuGroupService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(Integer wxMenuGroupId) {
		ResultData<Void> resultData = wxMenuGroupService.deleteOne(wxMenuGroupId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(Integer[] wxMenuGroupIds) {
		ResultData<Void> resultData = wxMenuGroupService.deleteBatch(wxMenuGroupIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxMenuGroup entity) {
		ResultData<Void> resultData = wxMenuGroupService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxMenuGroup entity) {
		ResultData<Void> resultData = wxMenuGroupService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxMenuGroup> selectOne(Integer wxMenuGroupId) {
		ResultData<WxMenuGroup> resultData = wxMenuGroupService.selectOne(wxMenuGroupId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxMenuGroup>> selectList(WxMenuGroup entity, Page page) {
		ResultData<List<WxMenuGroup>> resultData = wxMenuGroupService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxMenuGroup>> selectAll() {
		ResultData<List<WxMenuGroup>> resultData = wxMenuGroupService.selectAll();

		return resultData;
	}

}
