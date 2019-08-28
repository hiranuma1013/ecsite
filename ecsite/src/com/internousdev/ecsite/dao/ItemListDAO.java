package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util. ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	public ArrayList<ItemInfoDTO> getItemInfo() throws SQLException{
		ArrayList<ItemInfoDTO> itemInfoDTO=new ArrayList<ItemInfoDTO>();
		String sql="SELECT item_name, item_price, item_stock, id, insert_date FROM item_info_transaction";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO dto=new ItemInfoDTO();
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setId(resultSet.getString("id"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				itemInfoDTO.add(dto);
			}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }finally{
		    	connection.close();
		    }
		    return itemInfoDTO;
	}
}
