package com.tha103.newview.act.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tha103.newview.act.controller.ActWithPicsDTO;

public interface ActUpdateService {
	void updateActAndImages(HttpServletRequest request, HttpServletResponse response);

}
