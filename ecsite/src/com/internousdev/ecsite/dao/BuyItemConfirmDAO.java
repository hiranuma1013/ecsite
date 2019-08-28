package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemConfirmDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemConfirmDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private BuyItemConfirmDTO buyItemConfirmDTO=new BuyItemConfirmDTO();

	public BuyItemConfirmDTO itemStockConfirm(int count, int id) throws SQLException{

		String sql="SELECT item_stock FROM item_info_transaction WHERE id=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
			if(resultSet.getInt("item_stock")<count){
				buyItemConfirmDTO.setStockFlg(true);
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return buyItemConfirmDTO;
	}
}
