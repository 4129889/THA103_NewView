package com.tha103.newview.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tha103.newview.post.model.PostVO;
import com.tha103.newview.post.service.PostService;
import com.tha103.newview.post.service.PostServiceImpl;
import com.tha103.newview.postcategory.model.PostCategoryVO;
import com.tha103.newview.postpic.model.PostPicVO;
import com.tha103.newview.postpic.service.PostPicService;
import com.tha103.newview.postpic.service.PostPicServiceImpl;
import com.tha103.newview.user.model.UserVO;

@WebServlet("/DoPostServlet")
@MultipartConfig
public class DoPostServlet extends HttpServlet {
	private static final long serialVersionUID = -1195497717454804472L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		
		// ------------------------------------新增開始-------------------------------------------//

		if ("add".equals(action)) { // 接受来自forum_dopost.html请求(Ajax)

			
			/**************************************** 1.接受請求參數 ************************************/
			String postHeader = req.getParameter("postHeader").trim();
			Integer postCategoryID = Integer.valueOf(req.getParameter("postCategoryID"));
			String postContent = req.getParameter("postContent");
			String postPicStr = req.getParameter("img_base64");

			//System.out.println(postPicStr);
			// 針對Base64的格式先轉為Byte
			// 處理不必要資訊"dataimage/png;base64,"以及連接的 ";"

			List<byte[]> imageBytesList = new ArrayList<>();

			String[] postPicArray = postPicStr.split(",");

			for (String picBaseStr : postPicArray) {
				try {
					byte[] imageBytes = Base64.getDecoder().decode(picBaseStr);
					imageBytesList.add(imageBytes);
				} catch (IllegalArgumentException e) {
					// 拋出Base64解碼錯誤
					System.err.println("Base64 decoding error");
					e.printStackTrace();
				}

			}

			/***************************************** 2.開始新增數據***************************************/

			PrintWriter out = res.getWriter();

			PostService postSvc = new PostServiceImpl();

			Timestamp postDateTime = new Timestamp(System.currentTimeMillis());
			Timestamp lastEditedTime = new Timestamp(System.currentTimeMillis());

			PostVO postVO = new PostVO();
			UserVO userVO = new UserVO();
			
			// 用Session獲取用戶的userID
			String userIDString = (String) req.getSession().getAttribute("userID");
			Integer userID = Integer.parseInt(userIDString);
			
			userVO.setUserID(userID);
			postVO.setUserVO(userVO);

			PostCategoryVO postCategoryVO = new PostCategoryVO();
			postCategoryVO.setPostCategoryID(postCategoryID);
			postVO.setPostCategoryVO(postCategoryVO);

			postVO.setPostHeader(postHeader);
			postVO.setPostDateTime(postDateTime);
			postVO.setLastEditedTime(lastEditedTime);
			postVO.setPostContent(postContent);
			postVO.setDisLikeCount(0);
			postVO.setLikeCount(0);
			postVO.setPostStatus(1);

			Set<PostPicVO> set = new LinkedHashSet<>();
			for (byte[] b : imageBytesList) {
				PostPicVO pVO = new PostPicVO();
				pVO.setPost(postVO);
				pVO.setPostPic(b);
				set.add(pVO);
			}

			postVO.setPostPicVOs(set);

			postSvc.addPost(postVO);
			out.println("Success to add Image");

		}

		
		
		
		
		
		// ------------------------------------修改開始-------------------------------------------//

		if ("update".equals(action)) { // 接受来自forum_revisedopost.html请求(Ajax)

			Integer postID = Integer.valueOf(req.getParameter("postID"));
			String postHeader = req.getParameter("postHeader").trim();
			Integer postCategoryID = Integer.valueOf(req.getParameter("postCategoryID"));
			String postContent = req.getParameter("postContent");
			String postPicStr = req.getParameter("img_base64");
			System.out.println("------------------------------");
			System.out.println(postPicStr);
			System.out.println("------------------------------");
			// 針對Base64的格式先轉為Byte
			// 處理不必要資訊"dataimage/png;base64,"以及連接的 ";"

			List<byte[]> imageBytesList = new ArrayList<>();

			if (postPicStr != null && !postPicStr.isEmpty()) {
				String[] postPicArray = postPicStr.split(",");

				for (String picBaseStr : postPicArray) {
					try {
						byte[] imageBytes = Base64.getDecoder().decode(picBaseStr);
						imageBytesList.add(imageBytes);
					} catch (IllegalArgumentException e) {
						// 拋出Base64解碼錯誤
						System.err.println("Base64 decoding error");
						e.printStackTrace();
					}
				}
			}

			/****************************************** 2.開始新增數據 ***************************************/

			PrintWriter out = res.getWriter();

			PostService postSvc = new PostServiceImpl();
			PostVO existingPost = postSvc.getPostByPK(postID);

			Timestamp lastEditedTime = new Timestamp(System.currentTimeMillis());

			if (existingPost != null) {

				// 更新資料
				existingPost.setPostHeader(postHeader);
				existingPost.setPostContent(postContent);
				existingPost.setLastEditedTime(lastEditedTime);

				PostCategoryVO postCategoryVO = new PostCategoryVO();
				postCategoryVO.setPostCategoryID(postCategoryID);
				existingPost.setPostCategoryVO(postCategoryVO);

				
				// 刪除圖片
				PostPicService postpicSvc = new PostPicServiceImpl();
				postpicSvc.deletePostPic(postID);
				
				// 添加圖片
				Set<PostPicVO> set = new LinkedHashSet<>();
				for (byte[] b : imageBytesList) {
					PostPicVO pVO = new PostPicVO();
					pVO.setPost(existingPost);
					pVO.setPostPic(b);
					set.add(pVO);
				}
				existingPost.setPostPicVOs(set);

				// 更新實體資料
				postSvc.updatePost(existingPost);
				out.println("update success");

			} else {
				// 處理主鍵不存在的情况
				out.println("Post with ID " + postID + " not found.");
			}
			
			System.out.println("---------------END---------------");

		}
		
	}
}
