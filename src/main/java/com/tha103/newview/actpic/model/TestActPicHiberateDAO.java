package com.tha103.newview.actpic.model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.tha103.newview.act.model.ActVO;

public class TestActPicHiberateDAO {
	public byte[] gifToByteArray(String gif) throws IOException {
		File gifFile = new File(gif);

		BufferedImage image = ImageIO.read(gifFile);

		if (image != null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "gif", baos);
			return baos.toByteArray();
		} else {
			throw new IOException("Can not read .gif");
		}
	}

	public static void main(String[] args) throws Exception {
		ActPicDAO dao = new ActPicDAOHibernateImpl();
		TestActPicHiberateDAO daoPic = new TestActPicHiberateDAO();
////		// 新增
//		ActPic actPic = new ActPic();
//		ActVO act = new ActVO();
//
//		act.setActID(2);
//		actPic.setActID(act);
//		actPic.setActPic(daoPic.gifToByteArray("images/bg-01.jpg"));
//		dao.insert(actPic);
////
//		// 修改
		ActPic actPic = new ActPic();
		ActVO act = new ActVO();
		act.setActID(3);
		actPic.setActID(act);
		actPic.setActPicID(3);
		actPic.setActPic(daoPic.gifToByteArray("images/about-01.jpg"));
		dao.update(actPic);
////
//		// 刪除
//		dao.delete(5);
//
//		// 查詢單筆
//		ActPic act = dao.findByPrimaryKey(4);
//		System.out.print(act.getActPicID() + ",");
//		System.out.print(act.getActID() + ",");
//		System.out.print(act.getActPic() + ",");
//		System.out.println("---------------------");

		// 查詢多筆
//		List<ActPic> list = dao.getAll();
//		for (ActPic act : list) {
//			System.out.print(act.getActPicID() + ",");
//			System.out.print(act.getActID().getActName() + ",");
//			System.out.print(act.getActPic() + ",");
//
//			System.out.println();
//		}
	}
}
