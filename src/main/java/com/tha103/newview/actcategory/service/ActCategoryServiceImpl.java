//package com.tha103.newview.actcategory.service;
//
//import java.util.List;
//
//import com.tha103.newview.actcategory.model.ActCategory;
//import com.tha103.newview.actcategory.model.ActCategoryDAO;
//import com.tha103.newview.actcategory.model.ActCategoryDAOHibernateImpl;
//import com.tha103.newview.user.model.UserVO;
//
//public class ActCategoryServiceImpl implements ActCategoryService {
//	
//	private ActCategoryDAO actCategoryDAO;
//	
//	public ActCategoryServiceImpl() {
//		actCategoryDAO = new ActCategoryDAOHibernateImpl();	
//	}
//	
//	@Override
//	public int addActCategory(ActCategory actCategory) {
//		return actCategoryDAO.insert(actCategory);
//	}
//	
//}