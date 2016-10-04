package de.steve72.tutorials.mvcjparest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * AppConfig
 *
 * @author Steffen Bauer <schlupp2002@gmail.com>
 */

@Configuration
@EnableWebMvc
@ComponentScan("de.steve72.tutorials.mvcjparest")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        registry.viewResolver(viewResolver);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // wir mappen das Module-Web-Root auf eine Location
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

}