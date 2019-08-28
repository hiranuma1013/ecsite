package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	private UserListDAO userListDAO=new UserListDAO();
	private ArrayList<UserInfoDTO> userInfoList=new ArrayList<UserInfoDTO>();

	public String execute() throws SQLException{
		userInfoList=userListDAO.getUserInfo();

		String result=SUCCESS;
		return result;
	}

	public ArrayList<UserInfoDTO> getUserInfoList(){
		return userInfoList;
	}
}
