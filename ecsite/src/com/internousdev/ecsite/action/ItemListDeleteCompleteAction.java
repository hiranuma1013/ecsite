package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;



public class ItemListDeleteCompleteAction extends ActionSupport {

	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();

	public String execute() throws SQLException{

		itemListDeleteCompleteDAO.itemListDelete();

		String result=SUCCESS;
		return result;
	}
}
