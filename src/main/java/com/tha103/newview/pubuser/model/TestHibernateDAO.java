package com.tha103.newview.pubuser.model;

import java.util.List;

import com.tha103.newview.publisher.model.PublisherVO;

public class TestHibernateDAO {
	
	public static void main(String[] args) {
		PubUserHibernateDAO dao = new PubUserHibernateDAOImpl();
		
		//test add ok
//		PubUserVO pubuserVO1 = new PubUserVO();
//		PublisherVO publisherVO1 = new PublisherVO();
//		publisherVO1.setPubID(1);
//		
//		pubuserVO1.setPublisherVO(publisherVO1);
//		pubuserVO1.setPubNickname("Hiber");
//		pubuserVO1.setPubAccount("Hibernate");
//		pubuserVO1.setPubPassword("33142");
//		pubuserVO1.setPubAuthority((byte) 1);
//		dao.add(pubuserVO1);
//		System.out.println("Add PubUser success!");
		
		
		//test update OK
//		PubUserVO pubuserVO2 = new PubUserVO();
//		PublisherVO publisherVO2 = new PublisherVO();
//		publisherVO2.setPubID(1);
//		
//		pubuserVO2.setPubUserID(10);
//		pubuserVO2.setPublisherVO(publisherVO2);
//		pubuserVO2.setPubNickname("QQ");
//		pubuserVO2.setPubAccount("DD9999");
//		pubuserVO2.setPubPassword("33joij42");
//		pubuserVO2.setPubAuthority((byte) 1);
//		dao.update(pubuserVO2);
//		System.out.println("update PubUser success!!");
		
		
		//test delete OK
//		dao.delete(6);
//		System.out.println("delete success!!!");
		
		
		//test findByPK ok 
//		PubUserVO pubuserVO3 = dao.findByPK(10);
//		System.out.println(pubuserVO3.getPubUserID());
//		System.out.println(pubuserVO3.getPublisherVO().getPubID());
//		System.out.println(pubuserVO3.getPubNickname());
//		System.out.println(pubuserVO3.getPubAccount());
//		System.out.println(pubuserVO3.getPubPassword());
//		System.out.println(pubuserVO3.getPubAuthority());
//		System.out.println("===========");
		
		
		//test findAll 
//		List<PubUserVO> list = dao.getAll();
//		for(PubUserVO pubuserVO : list) {
//			System.out.print(pubuserVO.getPubUserID()+",");
//			System.out.print(pubuserVO.getPublisherVO().getPubID()+",");
//			System.out.print(pubuserVO.getPubNickname()+",");
//			System.out.print(pubuserVO.getPubAccount()+",");
//			System.out.print(pubuserVO.getPubPassword()+",");
//			System.out.print(pubuserVO.getPubAuthority()+",");
//			System.out.println(" ");
//		}
		
//		List<Object[]> listByPubID = dao.getListByPubID(1);
//		System.out.println(listByPubID);

		List<PubUserVO> listByPubID = dao.getListByPubID(1);
		System.out.println(listByPubID);
		
	}

}
