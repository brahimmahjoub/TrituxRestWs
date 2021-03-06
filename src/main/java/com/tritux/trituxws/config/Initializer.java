package com.tritux.trituxws.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.tritux.trituxws.config.DatabaseConfig;

/**
 * Initializer class is equivelent of web.xml file
 * 
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

@Order(1)
public class Initializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {DatabaseConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}