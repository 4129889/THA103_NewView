package com.tha103.newview.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tha103.newview.post.model.PostVO;
import com.tha103.newview.postmessage.model.PostMessageVO;

public class HotPostDTO {

	List<String> userNickname = new ArrayList<>();
	List<Timestamp> messageDate = new ArrayList<>();
	List<String> postHeader = new ArrayList<>();
	List<String> postMessages = new ArrayList<>();
	List<Integer> likeCounts = new ArrayList<>();
	List<Integer> dislikeCounts = new ArrayList<>();
	List<Integer> postID = new ArrayList<>();
	List<Integer> postCategoryID = new ArrayList<>();

	public HotPostDTO(PostVO postVOs) {
		
			this.postID.add(postVOs.getPostID());
			this.postCategoryID.add(postVOs.getPostCategoryVO().getPostCategoryID());
			this.likeCounts.add(postVOs.getLikeCount());
			this.dislikeCounts.add(postVOs.getDisLikeCount());
			this.userNickname.add(postVOs.getUserVO().getUserNickname());
			this.postHeader.add(postVOs.getPostHeader());

			Set<PostMessageVO> postMessageVOs = postVOs.getPostMessageVOs();
			for (PostMessageVO postMessageVO : postMessageVOs) {
				this.postMessages.add(postMessageVO.getMesContent());
				this.messageDate.add(postMessageVO.getMessageDate());
			}
	}

	public HotPostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HotPostDTO [userNickname=" + userNickname + ", messageDate=" + messageDate + ", postHeader="
				+ postHeader + ", postMessages=" + postMessages + ", likeCounts=" + likeCounts + ", dislikeCounts="
				+ dislikeCounts + "]";
	}
}
