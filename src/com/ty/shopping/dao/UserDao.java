package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ty.shopping.dto.User;
import com.ty.shopping.util.AES;
import com.ty.shopping.util.ConnectionObject;
import static com.ty.shopping.util.AppConstatnts.*;
import static com.ty.shopping.util.AppConstatnts.SCERECET_KEY;

public class UserDao {
	//VALIDATE USER//
	public User validdateUser(String email,String password)
	{
		String sql="select* from user where email=? and password=?";
		Connection connection=ConnectionObject.getConnection();
		try
		{
			String enc=AES.encrypt(password, SCERECET_KEY);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, enc);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				User user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setMobile(resultSet.getLong(5));
				return user;
			}
		
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		return null;
		
	}
	public int updateUser(int id,User user)
	{
		return 0;
	}
	public void deleteUserById(User user)
	{
		String sql="delect user where id=?";
		Connection connection=ConnectionObject.getConnection();
		try {
		PreparedStatement preparedstatement=connection.prepareStatement(sql);
		 preparedstatement.setInt(1, user.getId());
		 preparedstatement.execute();
		 System.out.println("data deleted");
		}
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		finally
		{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public List<User> getAllUserById()
	{
		return null;
	}
	
	
	
	public int saveUser(User user)
	{
		String enc=AES.encrypt(user.getPassword(), SCERECET_KEY);
		Connection connection=ConnectionObject.getConnection();
		String sql="insert into user values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, enc);
			preparedStatement.setLong(5, user.getMobile());
			return preparedStatement.executeUpdate();
			//System.out.println("Data inserted");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

}
