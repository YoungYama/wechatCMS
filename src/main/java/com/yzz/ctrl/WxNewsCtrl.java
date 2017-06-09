package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxNews;
import com.yzz.service.WxNewsService;

/** 
* 
* @description: 实体类WxNews的控制器WxNewsCtrl 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Controller
@RequestMapping("/wxNews")
public class WxNewsCtrl {

	@Resource
	WxNewsService wxNewsService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxNews entity) {
		ResultData<Void> resultData = wxNewsService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxNewsId) {
		ResultData<Void> resultData = wxNewsService.deleteOne(wxNewsId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxNewsIds) {
		ResultData<Void> resultData = wxNewsService.deleteBatch(wxNewsIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxNews entity) {
		ResultData<Void> resultData = wxNewsService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxNews entity) {
		ResultData<Void> resultData = wxNewsService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxNews> selectOne(String wxNewsId) {
		ResultData<WxNews> resultData = wxNewsService.selectOne(wxNewsId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxNews>> selectList(WxNews entity, Page page) {
		ResultData<List<WxNews>> resultData = wxNewsService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxNews>> selectAll() {
		ResultData<List<WxNews>> resultData = wxNewsService.selectAll();

		return resultData;
	}

}
