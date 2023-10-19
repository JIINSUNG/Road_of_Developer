package com.ssafy.book.util;


public class DBUtil {
	public void close(AutoCloseable... cs) {
		try {
			for (AutoCloseable c : cs) {
				if(c!=null) c.close();
			}
		} catch (Exception e) {
		}
	}
}
