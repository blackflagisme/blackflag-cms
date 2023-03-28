//package com.blackflag.common.config;
//
//import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
//import io.swagger.annotations.ApiOperation;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author blackflagisme zhengclfy@qq.com
// * @date 2023/3/27 11:27
// */
//@Configuration
//@EnableSwagger2WebMvc
//@AllArgsConstructor
//public class SwaggerConfig {
//    private final OpenApiExtensionResolver openApiExtensionResolver;
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //加了ApiOperation注解的类，生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                //包下的类，生成接口文档
//                //.apis(RequestHandlerSelectors.basePackage("com.blackflag.modules.*.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .extensions(openApiExtensionResolver.buildExtensions("BlackFlag"))
//                .directModelSubstitute(java.util.Date.class, String.class)
//                .securitySchemes(security())
//                .securityContexts(securityContexts());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("黑旗CMS")
//                .description("黑旗CMS接口文档")
//                .termsOfServiceUrl("")
//                .version("3.x")
//                .build();
//    }
//
//    /**
//     * 认证的安全上下文
//     */
//    private List<SecurityScheme> security() {
//        List<SecurityScheme> securitySchemes = new ArrayList<>();
//        securitySchemes.add(new ApiKey("token", "token", "header"));
//        return securitySchemes;
//    }
//
//    /**
//     * 授权信息全局应用
//     */
//    private List<SecurityContext> securityContexts() {
//        List<SecurityContext> securityContexts = new ArrayList<>();
//        securityContexts.add(SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.any()).build());
//        return securityContexts;
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        List<SecurityReference> securityReferences = new ArrayList<>();
//        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
//        return securityReferences;
//    }
//}
