package com.applet.utils.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtil {

	public static String inputStream2String(InputStream inStream,
			String encoding) {
		String result = null;
		try {
			if (inStream != null) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] tempBytes = new byte[2048];
				int count = -1;
				while ((count = inStream.read(tempBytes, 0, 2048)) != -1) {
					outStream.write(tempBytes, 0, count);
				}
				tempBytes = null;
				outStream.flush();
				result = new String(outStream.toByteArray(), encoding);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
}
