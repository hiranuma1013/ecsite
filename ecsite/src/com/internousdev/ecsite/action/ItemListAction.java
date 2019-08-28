package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport  {

	private ItemListDAO itemListDAO=new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemInfoList=new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
		itemInfoList=itemListDAO.getItemInfo();

		String result=SUCCESS;
		return result;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList(){
		return this.itemInfoList;
	}
}
