package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateId {
	public static String getId() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fd = f.format(d);
		return fd;
	}

	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStringDatex() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
}
