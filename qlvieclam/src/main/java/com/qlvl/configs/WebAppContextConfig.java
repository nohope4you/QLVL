/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlvl.formatters.CityFormatter;
import com.qlvl.formatters.DistrictFormatter;
import com.qlvl.formatters.EducationFormatter;
import com.qlvl.formatters.MajorFormatter;
import com.qlvl.formatters.TypeJobFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author ACER
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan( basePackages = {
    "com.qlvl.controllers"
    ,"com.qlvl.repository"
    ,"com.qlvl.service"
})
@PropertySource("classpath:configs.properties")
public class WebAppContextConfig implements WebMvcConfigurer{

    @Autowired
    private Environment env;
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
//    @Bean
//        public InternalResourceViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        r.setViewClass(JstlView.class);
//        r.setPrefix("WEB-INF/pages/");
//        r.setSuffix(".jsp");
//        
//        return r;
//    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
      registry.addFormatter(new CityFormatter());
      registry.addFormatter(new DistrictFormatter());
      registry.addFormatter(new EducationFormatter());
      registry.addFormatter(new MajorFormatter());
      registry.addFormatter(new TypeJobFormatter());
    }
     @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", this.env.getProperty("cloudinary.cloud_name"),
                        "api_key", this.env.getProperty("cloudinary.api_id"),
                        "api_secret", this.env.getProperty("cloudinary.api_secret"),
                        "secure", true));
        return cloudinary;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
    
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource m = new  ResourceBundleMessageSource();
        m.setBasenames("messages");  
        return m;
    }
     @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
    }
    
    
}
