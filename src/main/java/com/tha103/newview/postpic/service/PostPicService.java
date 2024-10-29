package com.tha103.newview.postpic.service;

import java.util.List;
import com.tha103.newview.postpic.model.PostPicVO;

public interface PostPicService {

	public int addPostPic(PostPicVO postPicVO);
	public int updatePostPic(PostPicVO postPicVO);
	public int deletePostPic(int postID);
	public int getPostPicByPK(int postPicID);
	public List<PostPicVO> getAll();
}
