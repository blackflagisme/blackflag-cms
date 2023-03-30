package com.blackflag.common.config;

import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
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

import java.util.List;

import static com.github.xiaoymin.knife4j.core.util.CollectionUtils.newArrayList;

/**
 * 接口文档配置
 * @author blackflagisme zhengclfy@qq.com
 * @date 2023/3/27 22:18
 */
@Configuration
public class SpringDocConfig {

    private static final String SECURITY_SCHEME_NAME = "Authorization";

//    @Bean
//    OpenAPI communityOpenApi() {
//        Contact contact = new Contact();
//        contact.setName("blackflagisme");
//        contact.setEmail("zhengclfy@qq.com");
//        contact.setUrl("https://github.com/blackflagisme/blackflag-cms.git");
//        contact.setName("黑旗");
//        return new OpenAPI(SpecVersion.V30)
//                // See https://swagger.io/docs/specification/authentication/ for more.
//                .components(new Components()
//                        .addSecuritySchemes("BasicAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
//                        .addSecuritySchemes("BearerAuth", new SecurityScheme()
//                                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))
//                )
//                .addSecurityItem(new SecurityRequirement().addList("BasicAuth").addList("BearerAuth"))
//                .info(new Info().title("黑旗 Next API").contact(contact).version("2.0.0"));
//    }

    @Bean
    OpenAPI communityOpenApi() {
        Contact contact = new Contact();
        contact.setName("blackflagisme");
        contact.setEmail("zhengclfy@qq.com");
        contact.setUrl("https://github.com/blackflagisme/blackflag-cms.git");
        contact.setName("黑旗");
        return new OpenAPI(SpecVersion.V30)
                .info(new Info().title("黑旗 Next API").contact(contact).version("2.0.0"))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                        .name(SECURITY_SCHEME_NAME)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
    }

    @Bean
    GroupedOpenApi defaultApi() {
        return GroupedOpenApi.builder()
                .group("default-api")
                .displayName("Default APIs")
                .pathsToMatch("/**")
                .build();
    }

}
