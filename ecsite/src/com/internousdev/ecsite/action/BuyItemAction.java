package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemConfirmDAO;
import com.internousdev.ecsite.dto.BuyItemConfirmDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int count;
	private String pay;
	private String errorMessage;
	private BuyItemConfirmDAO buyItemConfirmDAO=new BuyItemConfirmDAO();
	private BuyItemConfirmDTO buyItemConfirmDTO=new BuyItemConfirmDTO();

	public String execute() throws SQLException{
		String result=SUCCESS;
		session.put("count", count);
		buyItemConfirmDTO=buyItemConfirmDAO.itemStockConfirm(Integer.parseInt(session.get("count").toString()), Integer.parseInt(session.get("id").toString()));
		      if(buyItemConfirmDTO.getStockFlg()){
		    	  setErrorMessage("在庫が足りません");
		    	  result=ERROR;
		      }else{
		      int intCount=Integer.parseInt(session.get("count").toString());
		      int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		      session.put("total_price", intCount*intPrice);
		      String payment;
		      if(pay.equals("1")){
			      payment="現金払い";
			      session.put("pay", payment);
		      }else{
			      payment="クレジットカード";
			      session.put("pay", payment);
		      }
		      }
		return result;
	}

	public void setCount(int count){
		this.count=count;
	}

	public void setPay(String pay){
		this.pay=pay;
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
