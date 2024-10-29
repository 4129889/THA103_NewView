package com.tha103.newview.actcategory.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import com.tha103.newview.act.model.ActVO;
import com.tha103.newview.actcategory.model.*;
import com.tha103.newview.actcategory.service.*;



@WebServlet("/actcategory/actcategory.do")
public class ActCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("add".equals(action)) { // 來自activity-add.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***********************1.接收請求參數 - 輸入格式的錯誤處理**************/
			
			String actCategoryName = req.getParameter("actCategoryName").trim();
			if (actCategoryName == null || actCategoryName.trim().length() == 0) {
				errorMsgs.add("分類名稱，請勿留空");
			}
			
			ActCategory actCategory = new ActCategory();
			actCategory.setActCategoryName(actCategoryName);
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("actCategory", actCategory); 
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/Allpage-administrator/activity/activity-add.jsp");
				failureView.forward(req, res);
									return;
								}
			
			/***********************2.開始新增資料**************/
			
			ActCategoryService actSvc = new ActCategoryService();
			actCategory = actSvc.addActCategory(actCategoryName);
			
			/***********************3.新增完成，準備轉交(Send the Success view)*************/
			
			req.setAttribute("actCategory", actCategory);
			String url = "/Backstage/Allpage-administrator/activity/activity-category.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自ActCategory.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer actCategoryID = new Integer(req.getParameter("actCategoryID"));
				
				/***************************2.開始查詢資料****************************************/
				ActCategoryService actCategorySvc = new ActCategoryService();
				ActCategory actCategory = actCategorySvc.getOneActCategory(actCategoryID);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("actCategory", actCategory); // 資料庫取出的actCategory物件,存入req
				String url = "/Backstage/Allpage-administrator/activity/activity-update.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交activity-update.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		
		
		
		if ("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑
			
			try {
				Integer actCategoryID = new Integer(req.getParameter("actCategoryID").trim());
				
				String actCategoryName = req.getParameter("actCategoryName").trim();
				String categoryNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (actCategoryName == null || actCategoryName.trim().length() == 0) {
					errorMsgs.add("分類名稱，請勿留空");
				} else if(!actCategoryName.trim().matches(categoryNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("分類名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				ActCategory actCategory = new ActCategory();
				actCategory.setActCategoryName(actCategoryName);
				actCategory.setActCategoryID(actCategoryID);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("actCategory", actCategory); // 含有輸入格式錯誤的actCategory物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/Allpage-administrator/activity/activity-update.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				ActCategoryService actCategorySvc = new ActCategoryService();
				actCategory = actCategorySvc.updateActCategory(actCategoryID, actCategoryName);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				req.setAttribute("actCategory", actCategory); // 資料庫取出的list物件,存入request

                String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(req, res);
				
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/Allpage-administrator/activity/activity-update.jsp");
				failureView.forward(req, res);
			}					
		}
		
		
		if ("delete".equals(action)) {
			
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//			// 送出刪除的來源網頁路徑
//			String requestURL = req.getParameter("requestURL");
			
			Integer actCategoryID = Integer.valueOf(req.getParameter("actCategoryID"));
			
			ActCategoryService actCategorySvc = new ActCategoryService();
			ActCategory actCategory = actCategorySvc.getOneActCategory(actCategoryID);
			actCategorySvc.deleteActCategory(actCategoryID);
			
//			if (requestURL.equals("/Backstage/Allpage-administrator/activity/activity-category.jsp")
//				req.setAttribute("user-listByID", actCategorySvc.getOneActCategory(actCategory.getPublisherVO().getPubID()));

			
			
			String url = "/Backstage/Allpage-administrator/activity/activity-category.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
		
		
		
		
		
		
		
//		 ActCategoryDAO dao = new ActCategoryDAOHibernateImpl();
//		 List<ActCategory> actCategoryList = dao.getAll();
//		 
//		 
//		 String actCategoryName = req.getParameter("actCategoryName");
		 
		 
//		 for (ActCategory actCategory : actCategoryList) {
//			 
//		 }
		
		
	}
}