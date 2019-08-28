package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	public int itemListDelete() throws SQLException{

		String sql="DELETE FROM item_info_transaction";
		int result=0;

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			result=preparedStatement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}
}
