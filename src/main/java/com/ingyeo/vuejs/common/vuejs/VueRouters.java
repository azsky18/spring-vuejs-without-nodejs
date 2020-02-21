package com.ingyeo.vuejs.common.vuejs;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Lists;

public class VueRouters extends ForwardingCollection<VueRouter> {
	private List<VueRouter> vueRouters = Lists.newArrayList();

	public static VueRouters create(List<String> resources) {
		sort(resources);

		VueRouters vueRouters = new VueRouters();

		for (String path : resources) {
			VueRouter vueRouter = VueRouter.create(path);
			VueRouter parent = vueRouters.findParentComponent(vueRouter);

			if (parent != null) {
				parent.addChild(vueRouter);
			} else {
				vueRouters.add(vueRouter);
			}
		}

		return vueRouters;
	}

	private static void sort(List<String> paths) {
		paths.sort((a, b) -> {
			return a.length() - b.length();
		});
	}

	private VueRouter findParentComponent(VueRouter vueRouter) {
		for (VueRouter parent : vueRouters) {
			String parentPathName = parent.getPureName() + VueConfig.PATH_SEPARATOR;
			String childName = vueRouter.getComponent();
			String compareName = StringUtils.removeStart(childName, parentPathName);

			if (!compareName.contains(VueConfig.PATH_SEPARATOR)) {
				return parent;
			}
		}

		return null;
	}

	@Override
	protected Collection<VueRouter> delegate() {
		return vueRouters;
	}
}
