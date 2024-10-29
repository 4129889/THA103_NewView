package com.tha103.newview.act.model;

import java.text.SimpleDateFormat;

import com.tha103.newview.actcategory.model.ActCategory;
import com.tha103.newview.cityaddress.model.CityAddress;
import com.tha103.newview.cityaddress.model.CityAddressDAO;
import com.tha103.newview.cityaddress.model.CityAddressDAOHibernatelmpl;
import com.tha103.newview.publisher.model.PublisherVO;

public class TestHiberateDAO {
	public static void main(String[] args) throws Exception {
//		ActDAO dao = new ActDAOHibernateImpl();
//		CityAddressDAO cdao = new CityAddressDAOHibernatelmpl();
////		// 新增
//		ActVO act = new ActVO();
//		CityAddress city = new CityAddress();
//		PublisherVO pub = new PublisherVO();
//		ActCategory actCategory = new ActCategory();
//		act.setActName("新增");
//		act.setActPrice(12345);
//		actCategory.setActCategoryID(2);
//		act.setActCategory(actCategory);
//		pub.setPubID(2);
//		act.setPublisherVO(pub);
//		act.setActTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-08"));
//		city.setActAdressID(1);
//		act.setCityAddressID(city);;
//		act.setActScope(1);
//		act.setActIntroduce("有改到");
//		act.setActContent("有改到");
//		act.setTime(new SimpleDateFormat("HH:mm:ss").parse("12:10:00"));
//		act.setActDate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));		
//		act.setApprovalCondition(1);
//		act.setCityAddress("有改到");
//		dao.insert(act);
//
//		// 修改
//		ActVO act = new ActVO();
//		CityAddress city = new CityAddress();
//		
//		ActCategory actCategory = new ActCategory();
//		PublisherVO pub = new PublisherVO();
//		act.setActID(3);
//		
//		act.setActName("David Jr.");
//		act.setActPrice(12345);
//		actCategory.setActCategoryID(1);
//		act.setActCategory(actCategory);
//		pub.setPubID(2);
//		act.setPublisherVO(pub);
//		act.setActTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-08"));
//		
//		city = cdao.findByPrimaryKey(1);
//		System.out.print(city.getCityName());
//		
//		
//		act.setCityAddressID(city);
//		act.setActScope(1);
//		act.setActIntroduce("有改到");
//		act.setActContent("有改到");
//		act.setTime(new SimpleDateFormat("HH:mm:ss").parse("12:10:00"));
//		act.setActDate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));		
//		act.setApprovalCondition(1);
//		act.setCityAddress("有改到");
//		dao.update(act);
//
//		// 刪除
//		dao.delete(6);
//
//		// 查詢單筆
//		ActVO act = dao.findByPrimaryKey(4);
//		System.out.print(act.getActName() + ",");
//		System.out.print(act.getActPrice() + ",");
//		System.out.print(act.getActCategoryID() + ",");
//		System.out.print(act.getPublisherVOs().getPubName() + ",");
//		System.out.print(act.getActTime() + ",");
//		System.out.print(act.getCityAddressID() +",");
//		System.out.print(act.getActScope() + ",");
//		System.out.print(act.getActIntroduce() + ",");
//		System.out.print(act.getTime() + ",");
//		System.out.print(act.getActDate() + ",");
//		System.out.print(act.getApprovalCondition() + ",");
//		System.out.print(act.getCityAddress() + ",");
//		System.out.println("---------------------");

//		 查詢多筆
		
//		List<ActVO> list = dao. getAll();
//		ActPic actpic = new ActPic();
//		for (ActVO act : list) {
//			System.out.print(act.getActID() + ",");
//			System.out.print(act.getActName() + ",");
//			System.out.print(act.getActPrice() + ",");
//			System.out.print(act.getActCategoryID().getActCategoryName() + ",");
//			System.out.print(act.getPublisherVOs().getPubName() + ",");
//			System.out.print(act.getActTime() + ",");
//			System.out.print(act.getCityAddressID().getCityName() +",");
//			System.out.print(act.getActScope() + ",");
//			System.out.print(act.getActIntroduce() + ",");
//			System.out.print(act.getTime() + ",");
//			System.out.print(act.getActDate() + ",");
//			System.out.print(act.getApprovalCondition() + ",");
//			System.out.print(act.getCityAddress() + ",");
//			Set<ActPic> actPics = act.getActpics();
//			for (ActPic actPic : actPics) {
//			    System.out.print(actPic.getActPicID() + ",");
//			    
//			    byte[] imageData = actPic.getActPic(); 
//			    
//			    if (imageData != null) {
//			        String base64ImageData = Base64.getEncoder().encodeToString(imageData);
//			        System.out.print(base64ImageData + ",");
//			    } else {
//			       
//			        System.out.println("Image data is null");
//			    }
//			    
//			   
//			}
//
//
//			
//			System.out.println();
//		}
//		
		
	}
}
