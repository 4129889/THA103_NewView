package com.tha103.newview.report.model;

import java.util.List;

public class TestHibernateDAO {
	public static void main(String[] args) {
		ReportDAO dao = new ReportDAOImpl();

		// 新增
//		ReportVO report1 = new ReportVO();
//		report1.setUserID(1);
//		report1.setPostID(1);
//		report1.setReportContent("講話很糟糕");
//		report1.setReportStatus(0);
//		
//		dao.insert(report1);

		// 修改
//		ReportVO report2 = new ReportVO();
//		report2.setReportID(1);
//		report2.setUserID(1);
//		report2.setPostID(1);
//		report2.setReportContent("講話很糟糕");
//		report2.setReportStatus(0);
//		
//		dao.update(report2);

		// 刪除
//		dao.delete(2);

		// 查詢單筆
		ReportVO report3 = dao.findeByPrimaryKey(1);
		System.out.println(report3);

		// 查詢多筆
		List<ReportVO> list = dao.getAll();
		for (ReportVO lists : list) {
			System.out.println(lists);
		}
	}
}
