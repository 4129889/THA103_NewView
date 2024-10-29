package com.tha103.newview.admin.model;

import java.util.List;

public class TestHibernateDAO {
	
	public static void main(String[] args) {
		AdminHibernateDAOImpl dao = new AdminHibernateDAOImpl();
		
		//test update OK!!
//	    AdminVO admin = new AdminVO();
//		admin.setAdminID(1);
//		admin.setAdminName("newview");
//		admin.setAdminAccount("tha103_G5");
//		admin.setAdminPassword("newview");
//		admin.setAdminEmail("tha103G5@gmail.com");
//		dao.update(admin);
//		System.out.println("update success!");
		
		
		
		//test gatAll OK!!!
		List<AdminVO> list = dao.getAll();
		for(AdminVO admin2 : list) {
			System.out.print(admin2.getAdminID()+",");
			System.out.print(admin2.getAdminName()+",");
			System.out.print(admin2.getAdminAccount()+",");
			System.out.print(admin2.getAdminPassword()+",");
			System.out.print(admin2.getAdminEmail()+",");
		}
		
		
	}

	
}
