package com.kayleoi.springbootcommunity.config;

import com.kayleoi.springbootcommunity.intercept.MyInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {
//    以下WebMvcConfigurerAdapter 比较常用的重写接口
//    /** 解决跨域问题 **/
//    public void addCorsMappings(CorsRegistry registry) ;
//    /** 添加拦截器 **/
//    void addInterceptors(InterceptorRegistry registry);
//    /** 这里配置视图解析器 **/
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    void configureViewResolvers(ViewResolverRegistry registry);
//    /** 配置内容裁决的一些选项 **/
//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    /** 静态资源处理 **/
//    void addResourceHandlers(ResourceHandlerRegistry registry);
//    /** 默认静态资源处理器 **/
//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

    @Autowired
    private MyInterception myInterception;

    @Autowired
    private UploadConfig uploadConfig;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "/templates/index.html"); // 直接定向到static下的index.html中
        registry.addRedirectViewController("/index", "/"); // 直接定向到templates下的index.html中
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 配置静态资源。避免静态资源被拦截 ,方行的资源目录
     * 配置完这些将不被拦截
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/"); //static目录下
        registry.addResourceHandler("/static/js/lib/**")
                .addResourceLocations("classpath:/static/js/lib/"); //static目录下
        registry.addResourceHandler("/static/js/lib/codemirror/**")
                .addResourceLocations("classpath:/static/js/lib/codemirror/"); //static目录下
        registry.addResourceHandler("/templates/**") //
                .addResourceLocations("classpath:/templates/"); // templates目录下
        registry.addResourceHandler("/pimg/**").addResourceLocations("file:" + uploadConfig.getPimgPath());
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub

        registry.addInterceptor(myInterception).addPathPatterns("/**");

        super.addInterceptors(registry);
    }


}
