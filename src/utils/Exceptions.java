package utils;

import java.util.concurrent.Callable;

public class Exceptions {
	public static void printExpectedException(Callable<?> req) {
		try {
			req.call();
		} catch (Exception e) {
			System.out.println("Expected error: " + e.toString());
		}
	}
}
