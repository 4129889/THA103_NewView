package com.tha103.newview.act.service;

import org.hibernate.Session;

import com.tha103.newview.act.model.ActDAO;
import com.tha103.newview.actpic.model.ActPic;
import com.tha103.newview.actpic.model.ActPicDAO;
import com.tha103.util.HibernateUtil;

public class ActPicServiceImpl implements ActPicService{
	private ActPicDAO actPicDAO;
	
	
	public ActPicServiceImpl() {
	    
	}
	public ActPicServiceImpl(ActPicDAO actPicDAO) {
	    this.actPicDAO = actPicDAO;
	}
	
	public void deleteActPic(String toDelete) {
	    if (toDelete != null && !toDelete.isEmpty()) {
	        String[] ids = toDelete.split(","); 
	        // 分割獲得所有的ID

	        for(String idStr : ids) {
	            try {
	                int deleteId = Integer.parseInt(idStr);
	                // 將每個ID字符串轉成整数
	                ActPic actPicToDelete = actPicDAO.findByPrimaryKey(deleteId);

	                if (actPicToDelete != null) {
	                    actPicDAO.delete(actPicToDelete.getActPicID());
	                } 

	            } catch (NumberFormatException nfe) {
	                nfe.printStackTrace();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


}
