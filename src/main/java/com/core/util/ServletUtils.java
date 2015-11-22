package com.core.util;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {

	public static boolean isPublicResource(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if (uri.contains("/index") || uri.contains("/login")
				|| uri.contains("/Init") || uri.contains("/test"))
			return true;
		else
			return false;
	}

	public static boolean isStaticResource(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String staticUri = null;
		String contextPath = request.getContextPath();

		if (uri.contains("%27%20+%20%20")) {
			return true;
		}

		if (contextPath.endsWith("/"))
			staticUri = contextPath + "static";
		else
			staticUri = contextPath + "/static";

		if (uri.startsWith(staticUri) || uri.endsWith(".css")
				|| uri.endsWith(".js")
				|| //
				uri.endsWith(".gif") || uri.endsWith(".jpg")
				|| uri.endsWith(".png")) {
			return true;
		}

		return false;
	}
}
