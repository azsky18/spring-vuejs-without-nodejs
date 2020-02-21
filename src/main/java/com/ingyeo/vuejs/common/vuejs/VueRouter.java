package com.ingyeo.vuejs.common.vuejs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class VueRouter {
	private String path;
	private String component;
	private List<VueRouter> children = Lists.newArrayList();

	public static VueRouter create(String component) {
		VueRouter vueRouter = new VueRouter();
		vueRouter.setComponent(component);
		vueRouter.setPathFromComponent(component);
		return vueRouter;
	}

	public void addChild(VueRouter child) {
		String oldPath = child.getPath();
		String newPath = StringUtils.removeStart(oldPath, path + VueConfig.PATH_SEPARATOR);
		
		if (newPath.equals(path)) {
			newPath = "";
		}

		child.setPath(newPath);
		
//		VueRouter vueRouter = new VueRouter();
//		vueRouter.setComponent(component);
//		vueRouter.setPath(newPath);

		children.add(child);
	}

	public String getComponent() {
		return VueConfig.PATH_SEPARATOR + VueConfig.PAGES_PATH_NAME + component;
	}

	protected String getPureName() {
		return StringUtils.removeEnd(getComponent(), VueConfig.SUFFIX);
	}

	private void setPathFromComponent(String source) {
		if (VueConfig.getNotFoundPage().equals(source)) {
			setPath(VueConfig.VUE_ROUTER_ALL_PATH);
			return;
		}

		source = StringUtils.removeEnd(source, VueConfig.getIndexPage());

		source = source.replaceAll(VueConfig.FILE_VARIABLE_PREFIX, VueConfig.VUE_ROUTER_VARIABLE_PREFIX);

		if (StringUtils.isBlank(source)) {
			setPath(VueConfig.PATH_SEPARATOR);
			return;
		}

		setPath(StringUtils.removeEnd(source, VueConfig.SUFFIX));
	}
}
