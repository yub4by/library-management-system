package com.util;

import com.service.MainFrameAdmin;

public class AdminSwingUtil {
	
	//获得Frame对象
	private static MainFrameAdmin frame;

	public static MainFrameAdmin getFrame() {
		return frame;
	}

	public static void setFrame(MainFrameAdmin frame) {
		AdminSwingUtil.frame = frame;
	}
	
}
