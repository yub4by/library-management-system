package com.util;

import com.service.MainFrameReader;

public class ReaderSwingUtil {
		//获得Frame对象
		private static MainFrameReader frame;

		public static MainFrameReader getFrame() {
			return frame;
		}

		public static void setFrame(MainFrameReader frame) {
			ReaderSwingUtil.frame = frame;
		}
		

}
