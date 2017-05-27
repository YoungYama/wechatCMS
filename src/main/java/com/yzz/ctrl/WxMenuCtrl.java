package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenu;
import com.yzz.service.WxMenuService;

/** 
* 
* @description: 实体类WxMenu的控制器WxMenuCtrl 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 
@Controller
@RequestMapping("/wxMenu")
public class WxMenuCtrl {

	@Resource
	WxMenuService wxMenuService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxMenu entity) {
		ResultData<Void> resultData = wxMenuService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxMenuId) {
		ResultData<Void> resultData = wxMenuService.deleteOne(wxMenuId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxMenuIds) {
		ResultData<Void> resultData = wxMenuService.deleteBatch(wxMenuIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxMenu entity) {
		ResultData<Void> resultData = wxMenuService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxMenu entity) {
		ResultData<Void> resultData = wxMenuService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxMenu> selectOne(String wxMenuId) {
		ResultData<WxMenu> resultData = wxMenuService.selectOne(wxMenuId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxMenu>> selectList(WxMenu entity, Page page) {
		ResultData<List<WxMenu>> resultData = wxMenuService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxMenu>> selectAll() {
		ResultData<List<WxMenu>> resultData = wxMenuService.selectAll();

		return resultData;
	}

}
