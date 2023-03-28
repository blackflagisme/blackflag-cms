package com.blackflag.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 接口文档配置
 * @author blackflagisme zhengclfy@qq.com
 * @date 2023/3/27 22:18
 */
@Configuration
public class SpringDocConfig {

    @Bean
    OpenAPI haloOpenApi() {
        Contact contact = new Contact();
        contact.setName("blackflagisme");
        contact.setEmail("zhengclfy@qq.com");
        contact.setUrl("https://github.com/blackflagisme/blackflag-cms.git");
        contact.setName("黑旗");
        return new OpenAPI(SpecVersion.V30)
                // See https://swagger.io/docs/specification/authentication/ for more.
                .components(new Components()
                        .addSecuritySchemes("BasicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP).scheme("basic"))
                        .addSecuritySchemes("BearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))
                )
                .addSecurityItem(new SecurityRequirement().addList("BasicAuth").addList("BearerAuth"))
                .info(new Info().title("黑旗 Next API").contact(contact).version("2.0.0"));
    }

    @Bean
    GroupedOpenApi systemApi() {
        return GroupedOpenApi.builder()
                .group("system-custom-api")
                .displayName("Custom APIs in System")
                .pathsToMatch("/apiV1/**")
                .build();
    }

    @Bean
    GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("custom-custom-api")
                .displayName("Custom APIs in Custom")
                .pathsToMatch("/apiV1/**")
                .build();
    }

    @Bean
    GroupedOpenApi testApi() {
        return GroupedOpenApi.builder()
                .group("test-custom-api")
                .displayName("Custom APIs in Test")
                .pathsToMatch("/apiV1/test/**")
                .build();
    }

    @Bean
    GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("all-api")
                .displayName("All APIs")
                .pathsToMatch("/api/**", "/apis/**")
                .build();
    }

}
