package com.tha103.newview.actcategory.model;
import java.util.List;

import com.tha103.newview.act.*;

public class TestActCategoryHiberateDAO {
	public static void main(String[] args) throws Exception {
		ActCategoryDAO dao = new ActCategoryDAOHibernateImpl();

//		// 新增
//		ActCategory actCategory = new ActCategory();
//		actCategory.setActCategoryName("有加到");
//		dao.insert(actCategory);

//		// 修改
//		ActCategory actCategory = new ActCategory();
//		actCategory.setActCategoryID(8);
//		actCategory.setActCategoryName("有改到");
//		dao.update(actCategory);
//
//		// 刪除
//		dao.delete(8);
//
//		// 查詢單筆
//		ActCategory act = dao.findByPrimaryKey(4);
//		System.out.print(act.getActCategoryID() + ",");
//		System.out.print(act.getActCategoryName() + ",");
//		System.out.println("---------------------");

		// 查詢多筆
		List<ActCategory> list = dao.getAll();
		for (ActCategory act : list) {
			System.out.print(act.getActCategoryID() + ",");
			System.out.print(act.getActCategoryName() + ",");
			
			System.out.println();
		}
	}
}
