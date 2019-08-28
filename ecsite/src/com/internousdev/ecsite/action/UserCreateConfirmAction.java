package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.internousdev.ecsite.dto.UserCreateCheckDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;
	private UserCreateCompleteDAO userCreateCompleteDAO=new UserCreateCompleteDAO();
	private UserCreateCheckDTO userCreateCheckDTO=new UserCreateCheckDTO();

	public String execute() throws SQLException{

		String result=SUCCESS;

		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))){
			userCreateCheckDTO=userCreateCompleteDAO.checkUser(loginUserId);
			 if(userCreateCheckDTO.getCheckFlg()){
				 setErrorMessage("すでに登録されているログインIDです。");
				 result=ERROR;
			 }else{
			      session.put("loginUserId", loginUserId);
			      session.put("loginPassword", loginPassword);
			      session.put("userName", userName);
			 }
		}else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
}
