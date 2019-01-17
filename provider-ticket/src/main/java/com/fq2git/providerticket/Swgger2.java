package com.fq2git.providerticket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swgger2 {

    @Bean
    public Docket systemRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("电影票")
                .genericModelSubstitutes(DeferredResult.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fq2git.providerticket.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(systemApiInfo());
    }

    private ApiInfo systemApiInfo() {
        return new ApiInfoBuilder()
                .title("ticketApi")
                .description("动永科技 -> 电影票服务")
                .contact(new Contact("方强","http://www.baidu.com","1135918220@qq.com"))
                .version("1.0")
                .build();
    }
}
