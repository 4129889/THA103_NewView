package com.tha103.newview.postmessage.service;

import java.util.List;

import com.tha103.newview.postmessage.model.PostMessageVO;


public interface PostMessageService {

	public int addPostMessage(PostMessageVO postMessageVO);
	public int updatePostMessage(PostMessageVO postMessageVO);
	public int deletePostMessage(int postMessageID);
	public PostMessageVO getPostMessageByPK(int postMessageID);
	public List<PostMessageVO> getAll();
	
}
