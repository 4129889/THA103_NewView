package com.tha103.newview.act.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.newview.act.model.ActDAO;
import com.tha103.newview.act.model.ActDAOHibernateImpl;
import com.tha103.newview.act.model.ActVO;
import com.tha103.newview.act.service.ActService;
import com.tha103.newview.act.service.ActServiceImpl;
import com.tha103.newview.actpic.model.ActPicDAO;
import com.tha103.newview.actpic.model.ActPicDAOHibernateImpl;
@WebServlet("/actCategoryChange")
public class ActCategorySearch  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ActService actService;
	public ActCategorySearch() {
		super();
		ActDAO actDAO = new ActDAOHibernateImpl();
		ActPicDAO actPicDAO = new ActPicDAOHibernateImpl();
		actService = new ActServiceImpl(actDAO);		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Integer categoryID = null;
		List<ActWithPicsDTO> actList = null ; 
		String categoryIDstr = request.getParameter("categoryID");
		 if(categoryIDstr != null) {
			  categoryID = Integer.parseInt(categoryIDstr);
			  actList = actService.searchActsByCategory(categoryID); 
		 }
		 request.setAttribute("actWithPicsList", actList);
	     request.getRequestDispatcher("/SearchNewFile.jsp").forward(request, response);
		 
	}
	
}
