package com.tha103.newview.usediscount.model;

import java.util.List;

public class TestHibernateDAO {
	public static void main(String[] args) {
		UseDiscountDAO dao = new UseDiscountDAOImpl();

		// 新增
//		UseDiscountVO use1 = new UseDiscountVO();
//		use1.setDiscountNO(100);
//		use1.setUserID(2);
//		use1.setDitUsed(0);
//		
//		dao.insert(use1);
		
		// 修改
//		UseDiscountVO use2 = new UseDiscountVO();
//		use2.setUseDisID(1);
//		use2.setDiscountNO(1);
//		use2.setUserID(1);
//		use2.setDitUsed(0);
//		
//		dao.update(use2);
		// 刪除
//		dao.delete(3);

		// 查詢單筆
		UseDiscountVO use3 = dao.findeByPrimaryKey(1);
		System.out.println(use3);

		// 查詢多筆
		List<UseDiscountVO> list = dao.getAll();
		for(UseDiscountVO lists : list) {
			System.out.println(lists);
		}
	}
}
