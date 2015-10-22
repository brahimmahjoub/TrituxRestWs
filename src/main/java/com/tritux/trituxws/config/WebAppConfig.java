package com.tritux.trituxws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * WebAppConfig class is equivalent to servlet-dispatcher.xml file
 * 
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.tritux.trituxws")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/*
	 * 
	 * setupViewResolver method is equivalent in servlet-dispatcher.xml to
	 * 
	 * <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * 	<beans:property name="prefix" value="/WEB-INF/views/" />
	 * 	<beans:property name="suffix" value=".jsp" />
	 * </beans:bean>
	 *
	 * Resolves views selected for rendering by @Controllers to .jsp resources
	 * in the /WEB-INF/views directory
	 * 
	 */

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	/*
	 * 
	 * addResourceHandlers method is equivalent to
	 *
	 * <mvc:resources mapping="/resources/**" location="/resources/" />
	 * 
	 * in servlet-dispatcher.xml
	 */

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

}
