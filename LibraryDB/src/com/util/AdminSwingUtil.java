package com.util;

import com.service.MainFrameAdmin;

public class AdminSwingUtil {
	
	//���Frame����
	private static MainFrameAdmin frame;

	public static MainFrameAdmin getFrame() {
		return frame;
	}

	public static void setFrame(MainFrameAdmin frame) {
		AdminSwingUtil.frame = frame;
	}
	
}
