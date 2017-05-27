package com.yzz.entity; 

/** 
* 
* @description: wx_menu_group表的实体类WxMenuGroup 
* 
* @author 杨志钊 
* @date 2017-05-27 16:07:44 
*/ 

public class WxMenuGroup {

	private Integer wxMenuGroupId;//菜单组ID

	private String groupName;//菜单组名称

	private String wxPublicAccountId;//所属公众号ID

	private Integer isEnable;//是否启用，1：启用，0：禁用

	public Integer getWxMenuGroupId() { 
		return wxMenuGroupId; 
	} 

	public void setWxMenuGroupId(Integer wxMenuGroupId) { 
 		this.wxMenuGroupId = wxMenuGroupId; 
	} 

	public String getGroupName() { 
		return groupName; 
	} 

	public void setGroupName(String groupName) { 
 		this.groupName = groupName == null ? null : groupName.trim(); 
	} 

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

	public Integer getIsEnable() { 
		return isEnable; 
	} 

	public void setIsEnable(Integer isEnable) { 
 		this.isEnable = isEnable; 
	} 

 
 } 
