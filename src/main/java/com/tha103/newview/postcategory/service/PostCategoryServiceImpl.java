package com.tha103.newview.postcategory.service;

import java.util.List;
import java.util.Map;

import com.tha103.newview.postcategory.model.PostCategoryDAO;
import com.tha103.newview.postcategory.model.PostCategoryDAOImpl;
import com.tha103.newview.postcategory.model.PostCategoryVO;



public class PostCategoryServiceImpl implements PostCategoryService{
	
	private PostCategoryDAO postCategorydao;
	
	
	public PostCategoryServiceImpl() {
		postCategorydao = new PostCategoryDAOImpl();
	}


	@Override
	public int addPostCategory(PostCategoryVO postCategoryVO) {
		return postCategorydao.insert(postCategoryVO);
	}


	@Override
	public int updatePostCategory(PostCategoryVO postCategoryVO) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getPostCategoryByPK(int postCategoryID) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<PostCategoryVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}




}
