package com.tha103.newview.postcategory.service;

import java.util.List;

import com.tha103.newview.postcategory.model.PostCategoryVO;


public interface PostCategoryService {

	public int addPostCategory(PostCategoryVO PostCategoryVO);
	public int updatePostCategory(PostCategoryVO PostCategoryVO);
	public int getPostCategoryByPK(int PostCategoryID);
	public List<PostCategoryVO> getAll();
}
