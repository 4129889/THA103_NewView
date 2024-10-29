package com.tha103.newview.post.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.tha103.newview.post.service.PostService;
import com.tha103.newview.post.service.PostServiceImpl;

@WebServlet("/DeletePostServlet")
@MultipartConfig
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = -1195497717454804472L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");

		// ***********************************DeleteByPK**********************************//

		
		int postID = Integer.parseInt(req.getParameter("postID").trim());// 接受来自forum_revisedopost.html请求(Ajax)
		System.out.println(postID);
		PostService postSvc = new PostServiceImpl();
		postSvc.deletePost(postID);
		System.out.println("Success to delete Image");

		// -----------Json重導---------//

		HttpSession session = req.getSession();
		String location = (String) session.getAttribute("location");
		session.removeAttribute("location");
		String redirectPath = location != null ? location : "forum_home.html";

		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("location", redirectPath);
		Gson gson = new Gson();
		String json = gson.toJson(jsonData);
		res.getWriter().write(json);

	}
}