package com.yzz.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yzz.dao.WxPublicAccountDao;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;
import com.yzz.entity.WxMenu;
import com.yzz.entity.WxPublicAccount;
import com.yzz.service.WeChatApiService;
import com.yzz.util.ConstantUtil;
import com.yzz.util.WeChatSignUtil;

@Controller
@RequestMapping("/wxapi")
public class WeChatApiCtrl {

	private static final Logger logger = Logger.getLogger(WeChatApiCtrl.class);

	@Resource
	WeChatApiService weChatApiService;

	@Resource
	WxPublicAccountDao wxPublicAccountDao;

	/**
	 * 对公众号粉丝发出的不同类型的信息、事件请求进行处理，并给出相应的响应message【xml格式】
	 * 
	 * @param token
	 * @param request
	 * @param response
	 * @return 相应的响应message【xml格式】
	 */
	@RequestMapping(value = "/handler/{wxPublicAccountId}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handleMsgRequest(@PathVariable("wxPublicAccountId") String wxPublicAccountId,
			HttpServletRequest request, HttpServletResponse response) {
		String responsiveMsg = null;
		String token = null;
		try {
			WxPublicAccount account = wxPublicAccountDao.selectByPrimaryKey(wxPublicAccountId);
			if (account != null) {
				token = account.getToken();
			}
			// 对公众号粉丝发出的不同类型的信息、事件请求进行处理，并返回相应的响应message【xml格式】
			responsiveMsg = weChatApiService.handleMessage(account, request);// 响应信息
		} catch (Exception e) {
			logger.error("【POST请求】" + "TOKEN【" + token + "】请求处理出错：" + e.getMessage());
		}

		return responsiveMsg;
	}

	/**
	 * 验证微信开发者服务器地址的有效性
	 * 
	 * @param token
	 * @param request
	 * @return 验证结果
	 */
	@RequestMapping(value = "/handler/{wxPublicAccountId}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String publicAccountSignature(@PathVariable("wxPublicAccountId") String wxPublicAccountId,
			HttpServletRequest request) {
		String result = null;
		String token = null;
		try {
			WxPublicAccount account = wxPublicAccountDao.selectByPrimaryKey(wxPublicAccountId);
			if (account != null) {
				token = account.getToken();
			}
			// 验证微信开发者服务器地址的有效性

			result = WeChatSignUtil.validSign(token, request);
		} catch (Exception e) {
			logger.error("【GET请求】" + "TOKEN【" + token + "】验证微信开发者服务器地址的有效性时出错：" + e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/createMenu", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public ResultData<JSONObject> createMenu(WxMenu entity, HttpSession session) {
		SysUser sysUser = (SysUser) session.getAttribute(ConstantUtil.LOGINING_SYS_USER);
		String wxPublicAccountId = sysUser.getWxPublicAccountId();
		ResultData<JSONObject> resultData = weChatApiService.createMenu(entity, wxPublicAccountId);

		return resultData;
	}

}