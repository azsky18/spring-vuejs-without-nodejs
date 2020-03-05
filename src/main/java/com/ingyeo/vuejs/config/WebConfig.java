package com.ingyeo.vuejs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ingyeo.vuejs.common.vue.VueConfig;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		VueConfig.addViewControllers(registry);
	}

	@Bean
	public VueConfig vueConfig() {
		VueConfig config = new VueConfig();
		return config;
	}
}
