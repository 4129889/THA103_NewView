package com.tha103.newview.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.newview.likes.model.LikesVO;
import com.tha103.newview.likes.service.LikesService;
import com.tha103.newview.likes.service.LikesServiceImpl;
import com.tha103.newview.post.model.PostVO;
import com.tha103.newview.post.service.PostService;
import com.tha103.newview.post.service.PostServiceImpl;
import com.tha103.newview.user.model.UserVO;
import com.tha103.newview.user.service.UserService;
import com.tha103.newview.user.service.UserServiceImpl;

@WebServlet("/DoLikeDislikeServlet")
public class DoLikeDislikeServlet extends HttpServlet {
	private static final long serialVersionUID = 4941248261576452585L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	    req.setCharacterEncoding("UTF-8");
	    res.setContentType("application/json; charset=UTF-8");
	    String action = req.getParameter("action");

	    // 1.接收請求參數
	    int postID = Integer.parseInt(req.getParameter("postID").trim());
	    int likeCount = Integer.parseInt(req.getParameter("likeCount").trim());
	    int dislikeCount = Integer.parseInt(req.getParameter("dislikeCount").trim());

	    System.out.println(action + "," + postID + "," + likeCount + "," + dislikeCount);

	    // 2.獲得用戶資料+新增資料

	    // post表格相關
	    PostService postSvc = new PostServiceImpl();
	    PostVO PostVOs = postSvc.getPostByPK(postID);

	    // likes表格相關
	    LikesService likeSvc = new LikesServiceImpl();
	    LikesVO LikeVOs = new LikesVO();

	    // user表格相關
	    UserVO userVOs = new UserVO();
	    String currentUserID = (String) req.getSession().getAttribute("userID");
	    Integer userID = Integer.valueOf(currentUserID);

	    // visitorID設計
	    Random random = new Random();
	    Integer visitorID = random.nextInt(100000);
	    System.out.println(visitorID);

	    // 3.執行資料存入
	    if (action != null) {
	        if (action.equals("like") && userID != null) {

	            // 針對post表格的修改
	            int likeCounts = likeCount + 1;
	            PostVOs.setLikeCount(likeCounts);

	            // 針對Likes表格的新增
	            LikeVOs.setPostVO(PostVOs);
	            PostVOs.setPostID(postID);
	            LikeVOs.setUserVO(userVOs);
	            userVOs.setUserID(userID);
	            LikeVOs.setLikeOrNot(1); // 讚

	        } else if (action.equals("dislike") && userID != null) {

	            // 針對post表格的修改
	            int dislikeCounts = dislikeCount + 1;
	            PostVOs.setDisLikeCount(dislikeCounts);

	            // 針對DisLikes表格的新增
	            LikeVOs.setPostVO(PostVOs);
	            PostVOs.setPostID(postID);
	            LikeVOs.setUserVO(userVOs);
	            userVOs.setUserID(userID);
	            LikeVOs.setLikeOrNot(0); // 倒讚

	        } else if (action.equals("like") && userID == null) {

	            // 針對post表格的修改
	            int likeCounts = likeCount + 1;
	            PostVOs.setLikeCount(likeCounts);

	            // 針對Likes表格的新增
	            LikeVOs.setPostVO(PostVOs);
	            PostVOs.setPostID(postID);
	            LikeVOs.setLikeOrNot(1); // 讚
	            LikeVOs.setVisitorID(visitorID);//設定為定義網站遊客ID

	        } else if (action.equals("dislike") && userID == null) {

	            // 針對post表格的修改
	            int dislikeCounts = dislikeCount + 1;
	            PostVOs.setDisLikeCount(dislikeCounts);

	            // 針對Likes表格的新增
	            LikeVOs.setPostVO(PostVOs);
	            PostVOs.setPostID(postID);
	            LikeVOs.setLikeOrNot(0); // 倒讚
	            LikeVOs.setVisitorID(visitorID);//設定為定義網站遊客ID

	        }

	        postSvc.updatePost(PostVOs);
	        likeSvc.addLikes(LikeVOs);

	        // 創建Map來存儲新的計數數據
	        Map<String, Integer> jsonData = new HashMap<>();
	        jsonData.put("likeCount", PostVOs.getLikeCount());
	        jsonData.put("dislikeCount", PostVOs.getDisLikeCount());

	        // 使用Gson將Map轉換為JSON並寫入響應
	        Gson gson = new Gson();
	        String json = gson.toJson(jsonData);
	        res.getWriter().write(json);
	        res.getWriter().flush();
	    }
	}


}
