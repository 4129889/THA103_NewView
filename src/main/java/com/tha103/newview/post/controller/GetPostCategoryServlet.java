package com.tha103.newview.post.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.newview.post.model.PostDAO;
import com.tha103.newview.post.model.PostDAOImpl;
import com.tha103.newview.post.model.PostVO;
import com.tha103.newview.postmessage.model.PostMessageVO;


@WebServlet("/GetPostCategoryServlet")
@MultipartConfig
public class GetPostCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		String action = req.getParameter("action");
		
		if ("getbycate".equals(action)) { // 来自Fourm_home.html的请求

			// 1. 接收請求
			int postCategoryID = Integer.parseInt(req.getParameter("postCategoryID").trim());
			
			PostDAO dao = new PostDAOImpl();
			List<PostVO> posts = dao.findByCategory(postCategoryID);	
			
			List<Map<String, Object>> postList = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 設置日期時間格式
			
			for (PostVO post : posts) {
				Map<String, Object> postData = new HashMap<>();

				postData.put("userNickname", post.getUserVO().getUserNickname());
				postData.put("postHeader", post.getPostHeader());
				// 格式化日期時間
		        String formattedDateTime = sdf.format(post.getPostDateTime());
		        postData.put("postDateTime", formattedDateTime);
				postData.put("Hot", post.getLikeCount()+post.getDisLikeCount());			

				// 獲取postMessageID
				List<Integer> postMessageIDs = new ArrayList<>();
				for (PostMessageVO postMessage : post.getPostMessageVOs()) {
					postMessageIDs.add(postMessage.getPostMessageID());
				}
				int numberOfIDs = postMessageIDs.size();

				postData.put("msgCount", numberOfIDs);
				
				postList.add(postData);
			}

			Gson gson = new Gson();
			String jsonData = gson.toJson(postList);
			System.out.println(jsonData);
			res.getWriter().write(jsonData);
		}
	}
}