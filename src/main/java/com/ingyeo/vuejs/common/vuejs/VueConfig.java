package com.ingyeo.vuejs.common.vuejs;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

public class VueConfig {
	static String SUFFIX = ".vue";
	static boolean CACHE = false;
	static String STATIC_PATH_NAME = "static";
	static String PAGES_PATH_NAME = "pages";
	static String PATH_SEPARATOR = "/";
	static String NOT_FOUND_PAGE_NAME = "404";
	static String PATH_ROOT_PAGE_NAME = "index";
	static String FILE_VARIABLE_PREFIX = "_";
	static String VUE_ROUTER_VARIABLE_PREFIX = ":";
	static String VUE_ROUTER_ALL_PATH = "*";
	static String API_PATH = "api";
	static String INDEX_URI = "/index.html";

	public static String getNotFoundPage() {
		return VueConfig.PATH_SEPARATOR + VueConfig.NOT_FOUND_PAGE_NAME + VueConfig.SUFFIX;
	}

	public static String getIndexPage() {
		return VueConfig.PATH_SEPARATOR + VueConfig.PATH_ROOT_PAGE_NAME + VueConfig.SUFFIX;
	}

	public static String getVuePath() {
		return VueConfig.STATIC_PATH_NAME + VueConfig.PATH_SEPARATOR + VueConfig.PAGES_PATH_NAME;
	}
	
	public static void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:" + INDEX_URI);
		registry.addViewController("/{x:[\\w\\-]+}").setViewName("forward:" + INDEX_URI);
		registry.addViewController("/{x:^(?!" + VueConfig.API_PATH + "$).*$}/**/{y:[\\w\\-]+}").setViewName("forward:" + INDEX_URI);
	}

	public String getSuffix() {
		return VueConfig.SUFFIX;
	}

	public void setSuffix(String suffix) {
		VueConfig.SUFFIX = suffix;
	}

	public boolean isCache() {
		return VueConfig.CACHE;
	}

	public void setCache(boolean cache) {
		VueConfig.CACHE = cache;
	}

	public String getStaticPathName() {
		return VueConfig.STATIC_PATH_NAME;
	}

	public void setStaticPathName(String staticPathName) {
		VueConfig.STATIC_PATH_NAME = staticPathName;
	}

	public String getPagesPathName() {
		return VueConfig.PAGES_PATH_NAME;
	}

	public void setPagesPathName(String pagesPathName) {
		VueConfig.PAGES_PATH_NAME = pagesPathName;
	}

	public String getPathSeparator() {
		return VueConfig.PATH_SEPARATOR;
	}

	public void setPathSeparator(String pathSeparator) {
		VueConfig.PATH_SEPARATOR = pathSeparator;
	}

	public String getNotFoundPageName() {
		return VueConfig.NOT_FOUND_PAGE_NAME;
	}

	public void setNotFoundPageName(String notFoundPageName) {
		VueConfig.NOT_FOUND_PAGE_NAME = notFoundPageName;
	}
	
	public String getApiPath() {
		return VueConfig.API_PATH;
	}

	public void setApiPath(String apiPath) {
		VueConfig.API_PATH = apiPath;
	}
}
