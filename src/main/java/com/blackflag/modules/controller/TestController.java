package com.blackflag.modules.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blackflagisme zhengclfy@qq.com
 * @date 2023/3/27 22:00
 */
@RestController
@Tag(name = "SpringDoc Test", description = "测试接口")
@RequestMapping("/api")
public class TestController {

    @Operation(summary = "swagger v3 信息全部写头上", description = "描述的文字",
            parameters = {
                    @Parameter(name = "auth", description = "请求头", in = ParameterIn.HEADER),
                    @Parameter(name = "id", description = "id", in = ParameterIn.PATH),
                    @Parameter(name = "param", description = "参数"),
            },
            security = @SecurityRequirement(name = "需要认证"))
    @PostMapping("/test")
    public String test() {
        return "Hello, I'm BlackFlag";
    }

}
