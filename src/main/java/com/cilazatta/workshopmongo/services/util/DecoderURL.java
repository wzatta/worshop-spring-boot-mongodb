package com.cilazatta.workshopmongo.services.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecoderURL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
