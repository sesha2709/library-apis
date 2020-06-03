package com.fep.micro.libraryapis.libraryapis.utils;

public class LibraryApiUtils {

	public static boolean doesStringValueExists(String str) {

		if (str != null && str.trim().length() > 0) {
			return true;
		} else {
			return false;
		}

	}

}
