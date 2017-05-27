package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;
import com.yzz.entity.WxPublicAccount;
import com.yzz.service.WxPublicAccountService;
import com.yzz.util.ConstantUtil;

/** 
* 
* @description: 实体类WxPublicAccount的控制器WxPublicAccountCtrl 
* 
* @author 杨志钊 
* @date 2017-05-27 11:10:57 
*/ 
@Controller
@RequestMapping("/wxPublicAccount")
public class WxPublicAccountCtrl {

	@Resource
	WxPublicAccountService wxPublicAccountService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<Void> saveOne(WxPublicAccount entity, HttpSession session) {
		SysUser sysUser = (SysUser) session.getAttribute(ConstantUtil.LOGINING_SYS_USER);
		ResultData<Void> resultData = wxPublicAccountService.saveOne(entity, sysUser);

		return resultData;
	}
	
	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<Void> insertOne(WxPublicAccount entity) {
		ResultData<Void> resultData = wxPublicAccountService.insertOne(entity);
		
		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxPublicAccountId) {
		ResultData<Void> resultData = wxPublicAccountService.deleteOne(wxPublicAccountId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxPublicAccountIds) {
		ResultData<Void> resultData = wxPublicAccountService.deleteBatch(wxPublicAccountIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxPublicAccount entity) {
		ResultData<Void> resultData = wxPublicAccountService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxPublicAccount entity) {
		ResultData<Void> resultData = wxPublicAccountService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxPublicAccount> selectOne(String wxPublicAccountId) {
		ResultData<WxPublicAccount> resultData = wxPublicAccountService.selectOne(wxPublicAccountId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxPublicAccount>> selectList(WxPublicAccount entity, Page page) {
		ResultData<List<WxPublicAccount>> resultData = wxPublicAccountService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxPublicAccount>> selectAll() {
		ResultData<List<WxPublicAccount>> resultData = wxPublicAccountService.selectAll();

		return resultData;
	}

}
