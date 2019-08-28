package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO=new ItemCreateCompleteDAO();

	public String execute() throws SQLException{
		itemCreateCompleteDAO.createItemInfo(session.get("IN").toString(), Integer.parseInt(session.get("IP").toString()), Integer.parseInt(session.get("IS").toString()));

		String result=SUCCESS;

		return result;
	}

    public void setSession(Map<String, Object>session){
		this.session=session;
	}
}
