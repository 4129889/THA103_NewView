package com.tha103.newview.user.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tha103.newview.orders.model.OrdersVO;
import com.tha103.newview.post.model.PostVO;
import com.tha103.newview.post.service.PostService;
import com.tha103.newview.post.service.PostServiceImpl;
import com.tha103.newview.user.dto.HotPostDTO;
import com.tha103.util.HibernateUtil;

public class TestHibernateDAO {
	public static void main(String[] args) {

		UserDAO dao = new UserDAOImpl();

		// 新增
//		UserVO user1 = new UserVO();
//		user1.setUserName("abc");
//		user1.setUserAccount("b");
//		user1.setUserPassword("123");
//		user1.setUserBirth(java.sql.Date.valueOf("2023-09-07"));
//		user1.setUserCell("0987654321");
//		user1.setUserEmail("test@test.com");
//		user1.setUserNickname("c");
//		user1.setBuyAuthority(0);
//		user1.setSpeakAuthority(0);
//		
//		dao.insert(user1);

		// 修改
//		UserVO user2 = new UserVO();
//		user2.setUserID(1);
//		user2.setUserName("xxxx");
//		user2.setUserAccount("b");
//		user2.setUserPassword("123");
//		user2.setUserBirth(java.sql.Date.valueOf("2023-09-07"));
//		user2.setUserCell("0987654321");
//		user2.setUserEmail("test@test.com");
//		user2.setUserNickname("c");
//		user2.setBuyAuthority(0);
//		user2.setSpeakAuthority(0);
//		
//		dao.update(user2);

		// 刪除

//		dao.delete(3);

		// 查詢單筆
//		UserVO user3 = dao.findByPrimaryKey(1);
//		System.out.println(user3);

		// 查詢多筆
//		List<UserVO> list = dao.getAll();
//		for (UserVO lists : list) {
//			System.out.println(lists);
//		}

		// 使用 userAccount 查詢單筆
//		boolean notExist = dao.checkUserAccount("test_a");
//		System.out.println("userAccount: test_a is available = " + notExist);

		// 使用 userID 查詢 actPicID
		Integer userID = 1;
//		Optional<OrdersVO> op = dao.getOrderByUserID(userID);
//		OrdersVO ordersVO = op.get();
//		System.out.println(op);
//		OrdersVO ordersVO = dao.getOrderByUserID(userID);
//		System.out.println(ordersVO);

//		UserVO userVO = new UserVO();
//		OrdersVO ordersVO = new OrdersVO();
//		OrderListVO orderListVO = new OrderListVO();
//		ActVO actVO = new ActVO();
//		ActPic actPicVO = new ActPic();
//		
//		Integer orderID = ordersVO.getOrderID();
//		Integer orderListID = orderListVO.getOrderListID();
//		Integer actID = actVO.getActID();
//		Integer actPicID = actPicVO.getActPicID();

//		System.out.println(getOrderIdByUserID(userID));
//		System.out.println(dao.getActPicIDByUserID(1));
//		List<Object[]> listActPic = dao.getActPicIDByUserID(1);
//		System.out.println(listActPic);
//		for (int i = 0; i < listActPic.size(); i++) {
//			System.out.println("Act: " + listActPic.get(i));
//		}
//
//		List<Object[]> listPub = dao.getPublisherNameByUserID(1);
//		System.out.println(listPub);
//		for (int i = 0; i < listPub.size(); i++) {
//			System.out.println("Pub: " + listPub.get(i));
//		}
//
//		List<Object[]> listActName = dao.getActNameByUserID(1);
//		System.out.println(listActName);
//		for (int i = 0; i < listActName.size(); i++) {
//			System.out.println("ActName: " + listActName.get(i));
//		}
//		getActPicIDByUserID(2);

//		List<MyLikeActDTO> dto = new ArrayList<>();
//		List<Object[]> listMyLikeAct = dao.getMyLikeByUserID(1);
//
//		if (!listMyLikeAct.isEmpty()) {
//			for (Object[] data : listMyLikeAct) {
//				if (data.length >= 4) {
//					MyLikeActDTO myLikeActDTO = new MyLikeActDTO();
//					
//					myLikeActDTO.setUserID((Integer) (data[0]));
//					myLikeActDTO.setUserName((String) data[1]);
//					myLikeActDTO.setActName((String) data[2]);
//					myLikeActDTO.setActIntroduce((String) data[3]);
//					
//					dto.add(myLikeActDTO);
//					
//					System.out.println(myLikeActDTO);
//				}
//			}
//		}
//		System.out.println(dto.get(0));
		
//		MyLikeActDTO myLikeActDTO = new MyLikeActDTO(1);
//		OrderDTO orderDTO = new OrderDTO(userID);
//		System.out.println(myLikeActDTO);
//		System.out.println(orderDTO);
		
//		List<HomeDTO> homeList= new ArrayList<>();
//		ActService actSvc = new ActServiceImpl();
//		List<ActVO> actVOs = actSvc.getAll();
//		for(ActVO actVO : actVOs) {
//			HomeDTO homeDTO = new HomeDTO(actVO);
//			homeList.add(homeDTO);
//		}
//		System.out.println(homeList);
		


		// Optional<> 測試
//		UserService userSvc = new UserServiceImpl();
//		Optional<OrdersVO> op = userSvc.getOrderByUserID(userID);
//		if (op.isPresent()) {
//			OrdersVO ordersVO = op.get();
//			System.out.println(ordersVO);
//			UserVO userVO = ordersVO.getUserVO();
//			System.out.println(userVO);
//			
//			ordersVO.getOrderListVOs().stream()
//			.map(OrderListVO::getOrderListID)
//			.forEach(orderListID -> {
//				System.out.println("orderListID: " + orderListID);
//			});
//		}

//		ordersVO.stream()
//				.map(OrdersVO::getOrderID)
//				.forEach(ordersID -> {
//					System.out.println("ordersID: " + ordersID);
//				});
		
		List<OrdersVO> ordersList = dao.getOrderByUserID(1);
		System.out.println(ordersList);
	}

	public static List<Object[]> getActPicIDByUserID(Integer userID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			System.out.println("====================");
			session.beginTransaction();

//			List<Object[]> list2 = session.createNativeQuery("SELECT ap.ActPicID FROM user u "
//					+ "JOIN orders o ON u.userid = o.userid "
//					+ "JOIN orderlist ol ON o.orderID = ol.orderID "
//					+ "JOIN act a ON ol.actID = a.actID "
//					+ "JOIN actpic ap ON a.actID = ap.actID; ").list();

//			List<Object[]> list2 = session.createNativeQuery("SELECT ap.ActPicID FROM user u "
//					+ "JOIN orders o ON u.userid = o.userid "
//					+ "JOIN orderlist ol ON o.orderID = ol.orderID "
//					+ "JOIN act a ON ol.actID = a.actID "
//					+ "JOIN actpic ap ON a.actID = ap.actID "
//					+ "WHERE a.actID = ap.actID and u.userid = 1; ").list();

			List<Object[]> list2 = session.createNativeQuery("SELECT ap.ActPicID FROM user u "
					+ "JOIN orders o ON u.userid = o.userid " + "JOIN orderlist ol ON o.orderID = ol.orderID "
					+ "JOIN act a ON ol.actID = a.actID " + "JOIN actpic ap ON a.actID = ap.actID "
					+ "WHERE a.actID = ap.actID and u.userid = :userID ").setParameter("userID", userID).list();

			System.out.println(list2);
			System.out.println("====================");

			session.getTransaction().commit();
			return list2;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
		return null;
	}

	public static List<Integer> getOrderIdByUserID(Integer userID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();

			String sql = "SELECT o.ordersID FROM User u LEFT JOIN u.orders o ";

			Query query = session.createQuery(sql);
			List<Integer> orderIDLists = query.list();
//			UserVO userVO = (UserVO) session.createQuery(sql).setParameter("userEmail", email).uniqueResult();
			session.getTransaction().commit();
			return orderIDLists;

		} catch (Exception e) {
			session.getTransaction().rollback();

		}
		return null;
	}
}
