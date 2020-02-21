package com.ingyeo.vuejs.common.vuejs;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class VuePageComponentResourceLoader {
	private PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

	private List<String> cachedResources;

	public VueRouters vueRouters;

	public VueRouters getVueRouters() {
		if (!VueConfig.CACHE || vueRouters == null) {
			vueRouters = VueRouters.create(getResources());
		}

		return vueRouters;
	}

	public List<String> getResources() {
		if (!VueConfig.CACHE || CollectionUtils.isEmpty(cachedResources)) {
			cachedResources = collectResources();
		}

		return cachedResources;
	}

	private List<String> collectResources() {
		Resource[] resources;
		try {
			resources = resolver.getResources("classpath:" + VueConfig.getVuePath() + "/**");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return Arrays.stream(resources).map(item -> {
			try {
				return item.getFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}).filter(item -> {
			return item.isFile();
		}).map(item -> {
			String relativePath = StringUtils.remove(item.getAbsolutePath(), resourceRoot());
			return relativePath.replace(File.separator, VueConfig.PATH_SEPARATOR);
		}).collect(Collectors.toList());
	}

	private String resourceRoot() {
		try {
			File templatesRootFile = resolver.getResources("classpath:" + VueConfig.getVuePath())[0].getFile();
			return templatesRootFile.getAbsolutePath();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}