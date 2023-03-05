package kr.co.e4net.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeTime {
	public LocalDateTime toEntityDateTime(String localDateTime) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localdate = LocalDateTime.parse(localDateTime, formatter);
		return localdate;
	}
}
