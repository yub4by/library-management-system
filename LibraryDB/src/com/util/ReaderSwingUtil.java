package com.util;

import com.service.MainFrameReader;

public class ReaderSwingUtil {
		//���Frame����
		private static MainFrameReader frame;

		public static MainFrameReader getFrame() {
			return frame;
		}

		public static void setFrame(MainFrameReader frame) {
			ReaderSwingUtil.frame = frame;
		}
		

}
