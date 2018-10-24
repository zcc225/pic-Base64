package com.yanmaikeji.ygjydemo;

import java.util.ArrayList;

public class TestLIst {

	public static void main(String[] args) {
		ArrayList<User> arrayList = new ArrayList<User>();
		
		User user1 = new User();
//		User user2 = new User();
//		User user2 = new User();
//		User user3 = new User();
//		
		arrayList.add(user1);
		arrayList.add(user1);
		arrayList.add(user1);
		arrayList.add(user1);
		System.out.println(arrayList.toString());
		
		arrayList.remove(user1);
		System.out.println(arrayList.toString());
	}
	
	  
}
