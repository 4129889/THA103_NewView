package com.tha103.newview.actcategory.service;

import java.util.List;
import java.util.Set;

import com.tha103.newview.act.model.ActVO;
import com.tha103.newview.actcategory.model.ActCategory;
import com.tha103.newview.actcategory.model.ActCategoryDAO;
import com.tha103.newview.actcategory.model.ActCategoryDAOHibernateImpl;
import com.tha103.newview.pubuser.model.PubUserVO;

public class ActCategoryService {

	private ActCategoryDAO dao;

	public ActCategoryService() {
		dao = new ActCategoryDAOHibernateImpl();
	}

	public void addOneActCategory(String actCategoryName) {
		ActCategory actCategory = new ActCategory();

		actCategory.setActCategoryName(actCategoryName);

		dao.insert(actCategory);
		
		System.out.println("add categoryh success!");

	}

	public ActCategory addActCategory(String actCategoryName) {

		ActCategory actCategory = new ActCategory();

		actCategory.setActCategoryName(actCategoryName);

		dao.insert(actCategory);

		return actCategory;
	}

	public ActCategory updateActCategory(Integer actCategoryID, String actCategoryName) {

		ActCategory act = new ActCategory();

		act.setActCategoryID(actCategoryID);
		act.setActCategoryName(actCategoryName);		

		dao.update(act);

		return act;
	}

	public void deleteActCategory(Integer actCategoryID) {
		dao.delete(actCategoryID);
	}
	
	public ActCategory getOneActCategory(Integer actCategoryID) {
		return dao.findByPrimaryKey(actCategoryID);
	}

	public List<ActCategory> getAll() {
		return dao.getAll();
	}

}