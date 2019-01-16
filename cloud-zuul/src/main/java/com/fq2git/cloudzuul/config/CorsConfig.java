package com.fq2git.cloudzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域配置
 */
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        //允许cookie
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        //允许GET,POST...所有
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300L);
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
