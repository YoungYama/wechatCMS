package com.yzz.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxMenu;
import com.yzz.entity.WxPublicAccount;

public interface WeChatApiService {
	
	/**
	 * 处理公众号粉丝发出的请求
	 * @param token
	 * @param request
	 * @return
	 */
	String handleMessage(String token, HttpServletRequest request);

	/**
	 * 获取公众号的全局唯一票据access_token
	 * @param entity
	 * @return
	 */
	String getAccessToken(WxPublicAccount entity);
	
	/**
	 * 获取菜单
	 * @param accessToken
	 * @return
	 */
	String getMenu(String accessToken);
	
	/**
	 * 创建菜单
	 * @param entity
	 * @param wxCmsPublicAccountId
	 * @return
	 */
	ResultData<JSONObject> createMenu(WxMenu entity, String wxPublicAccountId);
	
	/**
	 * 删除
	 * @param accessToken
	 * @return
	 */
	boolean deleteMenu(String accessToken);

}
