package com.tha103.newview.publisher.model;

import java.util.List;

public class TestPubHibernateDAO {
	public static void main(String[] args) {
		PublisherHibernateDAO dao = new PublisherHibernateDAOImpl();
		
		//test add OK
		PublisherVO pub = new PublisherVO();
//		pub.setPubName("哈哈大笑娛樂公司");
//		pub.setPubEmail("hahahaha@gmail.com");
//		dao.add(pub);
//		System.out.println("Add Publisher success!");
		
		//test update OK
//		PublisherVO pub1 = new PublisherVO();
//		pub1.setPubID(6);
//		pub1.setPubName("別說不好笑喜劇工作坊");
//		pub1.setPubEmail("imfunny@gmail.com");
//		dao.update(pub1);
//		System.out.println("update Publisher success!");

		//test delete 
//		PublisherVO pub2 = new PublisherVO();
//		dao.delete(2);
//		System.out.println("delete Publisher success!");
		
		//test findByPK OK
		PublisherVO pub3 = dao.findByPK(4);
		System.out.print(pub3.getPubID());
		System.out.print(pub3.getPubName());
		System.out.print(pub3.getPubEmail());
		
		//test gatAll OK
//		List<PublisherVO> list = dao.getAll();
//		for(PublisherVO pub4 : list) {
//			System.out.print(pub4.getPubID()+",");
//			System.out.print(pub4.getPubName()+",");
//			System.out.print(pub4.getPubEmail()+",");
//			System.out.println(" ");
//		}

	}

}
