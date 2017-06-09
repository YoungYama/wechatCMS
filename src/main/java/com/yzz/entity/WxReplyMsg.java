package com.yzz.entity; 

/** 
* 
* @description: wx_reply_msg表的实体类WxReplyMsg 
* 
* @author 杨志钊 
* @date 2017-06-01 13:52:12 
*/ 

public class WxReplyMsg {

	private String wxReplyMsgId;//回复消息的ID

	private String wxPublicAccountId;//所属公众号ID

	private String mediaId;//对应的文本、图文等类型信息的ID

	private String msgType;//消息类型：text；news等等

	private Integer replyType;//回复方式：0：关注回复；1：自动回复；2：关键字回复

	private String keyword;//关键词

	public String getWxReplyMsgId() { 
		return wxReplyMsgId; 
	} 

	public void setWxReplyMsgId(String wxReplyMsgId) { 
 		this.wxReplyMsgId = wxReplyMsgId == null ? null : wxReplyMsgId.trim(); 
	} 

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

	public String getMediaId() { 
		return mediaId; 
	} 

	public void setMediaId(String mediaId) { 
 		this.mediaId = mediaId == null ? null : mediaId.trim(); 
	} 

	public String getMsgType() { 
		return msgType; 
	} 

	public void setMsgType(String msgType) { 
 		this.msgType = msgType == null ? null : msgType.trim(); 
	} 

	public Integer getReplyType() { 
		return replyType; 
	} 

	public void setReplyType(Integer replyType) { 
 		this.replyType = replyType; 
	} 

	public String getKeyword() { 
		return keyword; 
	} 

	public void setKeyword(String keyword) { 
 		this.keyword = keyword == null ? null : keyword.trim(); 
	} 

 
 } 
