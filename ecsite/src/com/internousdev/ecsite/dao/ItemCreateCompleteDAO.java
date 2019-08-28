package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
public class ItemCreateCompleteDAO {

	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();
	DateUtil dateUtil=new DateUtil();
	String sql="INSERT INTO item_info_transaction (item_name, item_price, item_stock, insert_date) VALUES(?,?,?,?)";

	public void createItemInfo(String itemName, int itemPrice, int itemStock) throws SQLException{

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setInt(2, itemPrice);
			preparedStatement.setInt(3, itemStock);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
