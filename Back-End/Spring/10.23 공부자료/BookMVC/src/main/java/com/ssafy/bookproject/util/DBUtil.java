package com.ssafy.bookproject.util;

import org.springframework.stereotype.Component;

@Component
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
