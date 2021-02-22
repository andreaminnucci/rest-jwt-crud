package com.company.demo.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class MessageConfig {

	@Bean
    public Properties yamlProperties() throws IOException {
        YamlPropertiesFactoryBean bean = new YamlPropertiesFactoryBean();
        bean.setResources(new ClassPathResource("message.yml"));
        return bean.getObject();
    }
	
	@Bean
	public MessageSource messageSource() throws IOException {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setCommonMessages(yamlProperties());
		return messageSource;
	}
}
