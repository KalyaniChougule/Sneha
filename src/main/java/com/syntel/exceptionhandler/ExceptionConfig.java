package com.syntel.exceptionhandler;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * The class declares required bean for central exception handling. There are 2 types of exceptions handled
 * 1. Technical and 2. business
 * There are corresponding property files in src/main/resource directory to declare custom error numbers and error messages  
 * 
 * i18n is done by defining separate property files based on locale and language. 
 */ 
@Configuration
public class ExceptionConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Declare a bean for technical error messages. The base name refers property file name e.g. technicalMessages_fr.properties
	 * @return the resource bundle message source
	 */
	@Bean(name = "techMessageSource")
	public ResourceBundleMessageSource techMessageSource() {
		ResourceBundleMessageSource messageBundle = new ResourceBundleMessageSource();
		messageBundle.setBasename("technicalMessages");
		messageBundle.setDefaultEncoding("UTF-8");
		messageBundle.setUseCodeAsDefaultMessage(true);
		return messageBundle;
	}

	/**
	 * Business messages.
	 *
	 * @return the resource bundle message source
	 */
	@Bean(name = "bussinessMessageSource")
	public ResourceBundleMessageSource businessMessages() {
		ResourceBundleMessageSource messageBundle = new ResourceBundleMessageSource();
		messageBundle.setBasename("businessMessages");
		messageBundle.setDefaultEncoding("UTF-8");
		messageBundle.setUseCodeAsDefaultMessage(true);
		return messageBundle;

	}

	/**
	 * Locale change interceptor.
	 *
	 * @return the locale change interceptor
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	/**
	 * This will help to resolve the user locale  
	 *
	 * @return the locale resolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
