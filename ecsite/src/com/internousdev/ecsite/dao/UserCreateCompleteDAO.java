package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserCreateCheckDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date) VALUES(?,?,?,?)";
	private UserCreateCheckDTO userCreateCheckDTO=new UserCreateCheckDTO();

	public void createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException{

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

	public UserCreateCheckDTO checkUser(String loginUserId) throws SQLException{

		String sql="SELECT login_id FROM login_user_transaction WHERE login_id=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
			      if(resultSet.getString("login_id") !=null){
				      userCreateCheckDTO.setCheckFlg(true);
			      }
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return userCreateCheckDTO;
	}
}

