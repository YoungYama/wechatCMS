package com.yzz.entity; 

/** 
* 
* @description: wx_text表的实体类WxText 
* 
* @author 杨志钊 
* @date 2017-06-01 13:52:12 
*/ 

public class WxText {

	private String wxTextId;//文本消息ID

	private String wxPublicAccountId;//所属公众号ID

	private String content;//内容

	public String getWxTextId() { 
		return wxTextId; 
	} 

	public void setWxTextId(String wxTextId) { 
 		this.wxTextId = wxTextId == null ? null : wxTextId.trim(); 
	} 

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

	public String getContent() { 
		return content; 
	} 

	public void setContent(String content) { 
 		this.content = content == null ? null : content.trim(); 
	} 

 
 } 
