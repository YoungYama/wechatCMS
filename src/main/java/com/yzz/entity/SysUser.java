package com.yzz.entity;

/** 
* 
* @description: sys_user表的实体类SysUser 
* 
* @author 杨志钊 
* @date 2017-05-27 11:10:57 
*/ 

public class SysUser {

	private String sysUserId;//用户ID

	private String userName;//用户名

	private String password;//用户密码

	private String headImg;//用户头像

	private String phone;//手机号

	private String email;//邮箱

	private String wxPublicAccountId;//关联的公众号ID

	private String registerTime;//注册时间
	
	private Integer userRole;//用户角色：0：系统管理员;1：系统用户
	
	private String loginAccount;//登录账号

	public String getSysUserId() { 
		return sysUserId; 
	} 

	public void setSysUserId(String sysUserId) { 
 		this.sysUserId = sysUserId == null ? null : sysUserId.trim(); 
	} 

	public String getUserName() { 
		return userName; 
	} 

	public void setUserName(String userName) { 
 		this.userName = userName == null ? null : userName.trim(); 
	} 

	public String getPassword() { 
		return password; 
	} 

	public void setPassword(String password) { 
 		this.password = password == null ? null : password.trim(); 
	} 

	public String getHeadImg() { 
		return headImg; 
	} 

	public void setHeadImg(String headImg) { 
 		this.headImg = headImg == null ? null : headImg.trim(); 
	} 

	public String getPhone() { 
		return phone; 
	} 

	public void setPhone(String phone) { 
 		this.phone = phone == null ? null : phone.trim(); 
	} 

	public String getEmail() { 
		return email; 
	} 

	public void setEmail(String email) { 
 		this.email = email == null ? null : email.trim(); 
	} 

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

	public String getRegisterTime() { 
		return registerTime; 
	} 

	public void setRegisterTime(String registerTime) { 
 		this.registerTime = registerTime == null ? null : registerTime.trim(); 
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount == null ? null : loginAccount.trim(); 
	} 
 
 } 
