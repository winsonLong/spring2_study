package com.longson.boot05web01.config;

import com.longson.boot05web01.GuiguMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

   /* @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        UrlPathHelper urlPathHelper=new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);

    }*/
/*  @Bean
    public WebMvcConfigurer webMvcConfigurer(){
       return new WebMvcConfigurer() {
           @Override
           public void configurePathMatch(PathMatchConfigurer configurer){
               UrlPathHelper urlPathHelper=new UrlPathHelper();
               urlPathHelper.setRemoveSemicolonContent(false);
               configurer.setUrlPathHelper(urlPathHelper);
           }
       };
    }*/


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){


       return new WebMvcConfigurer() {
           @Override
           public void configurePathMatch(PathMatchConfigurer configurer) {

           }

           @Override
           public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
               //Map<String, MediaType> mediaTypes
               Map<String, MediaType> mediaTypes=new HashMap<>();
               mediaTypes.put("json",MediaType.APPLICATION_JSON);
               mediaTypes.put("xml",MediaType.APPLICATION_ATOM_XML);
               mediaTypes.put("gg",MediaType.parseMediaType("application/x-guigu"));

               //请求头
               HeaderContentNegotiationStrategy headerContentNegotiationStrategy=new HeaderContentNegotiationStrategy();

               //指定支持解析那些参数对应的哪些媒体类型
               ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
               configurer.strategies(Arrays.asList(parameterStrategy,headerContentNegotiationStrategy));
           }

           @Override
           public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

           }

           @Override
           public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

           }

           @Override
           public void addFormatters(FormatterRegistry registry) {

           }

           @Override
           public void addInterceptors(InterceptorRegistry registry) {

           }

           @Override
           public void addResourceHandlers(ResourceHandlerRegistry registry) {

           }

           @Override
           public void addCorsMappings(CorsRegistry registry) {

           }

           @Override
           public void addViewControllers(ViewControllerRegistry registry) {

           }

           @Override
           public void configureViewResolvers(ViewResolverRegistry registry) {

           }

           @Override
           public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

           }

           @Override
           public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

           }

           @Override
           public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

           }

           @Override
           public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new GuiguMessageConverter());
           }

           @Override
           public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

           }

           @Override
           public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

           }

           @Override
           public Validator getValidator() {
               return null;
           }

           @Override
           public MessageCodesResolver getMessageCodesResolver() {
               return null;
           }
       };
    }
}
