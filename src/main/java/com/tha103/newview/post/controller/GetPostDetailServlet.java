package com.tha103.newview.post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
import com.tha103.newview.postpic.model.PostPicVO;

@WebServlet("/GetPostDetailServlet")
@MultipartConfig
public class GetPostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = -1195497717454804472L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");

		// ***********************************GetPostDetail/FindByPK**********************************//

		
		int postID = Integer.parseInt(req.getParameter("postID").trim());
		
		PostDAO dao = new PostDAOImpl();
		PostVO post = dao.findByPrimaryKey(postID);	
		
		List<String> postpics = new ArrayList<>();
		for (PostPicVO pic : post.getPostPicVOs()) {
			if (pic.getPostPic() != null && pic.getPostPic().length != 0) {
				byte[] picBytes = pic.getPostPic();
				String base64Image = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(picBytes);
				postpics.add(base64Image);
			}
		}
		
		List<Integer> postMessageIDs = new ArrayList<>();
		for (PostMessageVO postMessage : post.getPostMessageVOs()) {
			postMessageIDs.add(postMessage.getPostMessageID());
		}
		

		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("postHeader", post.getPostHeader());
		jsonData.put("postContent", post.getPostContent());
		jsonData.put("likeCount", post.getLikeCount());
		jsonData.put("dislikeCount", post.getDisLikeCount());
		jsonData.put("postDateTime", post.getPostDateTime().toString());
		jsonData.put("lastEditedTime", post.getLastEditedTime().toString());
		jsonData.put("postStatus", post.getPostStatus());
		jsonData.put("userName", post.getUserVO().getUserNickname()); // 作者訊息
		jsonData.put("userAccount", post.getUserVO().getUserAccount()); // 作者訊息
		jsonData.put("postPics", postpics); // 圖片訊息
		jsonData.put("categoryName", post.getPostCategoryVO().getPostCategoryName()); // 分類訊息
		jsonData.put("msgID", postMessageIDs); // 分類訊息
		jsonData.put("postID", postID); // 分類訊息
		
		System.out.println(jsonData);
		
		Gson gson = new Gson();
		String json = gson.toJson(jsonData);
		res.getWriter().write(json);

	}
}
