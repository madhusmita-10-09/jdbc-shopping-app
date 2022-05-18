package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.User;

public class TestUserInsert {
	public static void main(String[] args)
	{
		//INSERT DATA IN TO DATA BASE//
//	   User user=new User();
//     user.setId(4);
//     user.setName("nitish");
//     user.setEmail("nitish@gmail.com");
//     user.setPassword("bhs35");
//     user.setMobile(9352748);
//	
	//User res=dao.validdateUser("nitish@gmail.com","bhs35");
	
	
//	int res=dao.saveUser(user);
//	if(res>0)
//	{
//		System.out.println("Data inserted");
//	}
//	else
//	{
//		System.out.println("NO data found");
//	}
		//CHECK PASSWORD IS CORRECT OR NOT//
//		UserDao dao=new UserDao();
//		User res=dao.validdateUser("nitish@gmail.com", "bhs35");
//		if(res!=null)
//		{
//			System.out.println("user detailed match");
//		}
//		else
//		{
//			System.out.println(" User detailed not matched");
//		}
//		
		//DELECT USER BY ID//
		User user=new User();
		user.setId(1);
		
		UserDao dao=new UserDao();
	     dao.deleteUserById(user);
		
		
		
	
	
		
 }
	

}
