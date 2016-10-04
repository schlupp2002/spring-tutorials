package de.steve72.tutorials.mvcjparest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * AppInit
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{AppConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {

        return null;
    }


    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }
}