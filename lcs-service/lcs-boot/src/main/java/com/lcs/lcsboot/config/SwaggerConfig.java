package com.lcs.lcsboot.config;

/**
 * @author mis_wu
 * @date 2021/11/29 20:17
 */


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration //applicationContext.xml
@EnableSwagger2//开启Swagger
@EnableKnife4j //开启knif4j
public class SwaggerConfig {
//
//    @Value("${knife4j.password_token_url}")
//    private String passwordTokenUrl;

    @Bean
    public Docket restApi() {
        //schema
        List<GrantType> grantTypes = new ArrayList<>();
        //密码模式
//        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
//        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
//        OAuth oAuth = new OAuthBuilder().name("oauth2")
//                .grantTypes(grantTypes).build();
//        //context
        //scope方位
        List<AuthorizationScope> scopes = new ArrayList<>();
        scopes.add(new AuthorizationScope("read", "read  resources"));
        scopes.add(new AuthorizationScope("write", "write resources"));
        scopes.add(new AuthorizationScope("reads", "read all resources"));
        scopes.add(new AuthorizationScope("writes", "write all resources"));

        SecurityReference securityReference = new SecurityReference("oauth2", scopes.toArray(new AuthorizationScope[]{}));
        SecurityContext securityContext = new SecurityContext(Lists.newArrayList(securityReference), PathSelectors.ant("/**"));
        //schemas
//        List<SecurityScheme> securitySchemes = Lists.newArrayList(oAuth);
        //securyContext
        List<SecurityContext> securityContexts = Lists.newArrayList(securityContext);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // .apis(RequestHandlerSelectors.basePackage("com.lms.admin.controller"))
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts)
//                .securitySchemes(securitySchemes)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("5G定位适配模块  ")
                .description("<div style='font-size:14px;color:red;'></div>")
                //  .termsOfServiceUrl("https://www.lms.tech")
                .contact(new Contact("技术团队", "", ""))
                .license("Open Source")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }

}
