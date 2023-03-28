package com.blackflag.modules.controller.community;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackflag.common.utils.ResponseResult;
import com.blackflag.modules.entity.CommunityThought;
import com.blackflag.modules.service.CommunityThoughtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 社区想法
 * @author blackflagisme zhengclfy@qq.com
 */
@RestController
@Tag(name = "社区想法", description = "社区-想法Api")
@RequestMapping("/community/thought")
public class ThoughtController {

    @Autowired
    private CommunityThoughtService communityThoughtService;

    @GetMapping("page")
    @Operation(summary = "分页",parameters = {
        @Parameter(name = "page", description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true),
        @Parameter(name = "limit", description = "每页显示记录数", in = ParameterIn.QUERY, required = true),
        @Parameter(name = "orderField", description = "排序字段", in = ParameterIn.QUERY),
        @Parameter(name = "order", description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY),
    })
    public ResponseResult<IPage<CommunityThought>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        Page<CommunityThought> page = new Page<>(Long.parseLong((String) params.get("page")), Long.parseLong((String) params.get("limit")));
        IPage<CommunityThought> pages = communityThoughtService.page(page);
        return new ResponseResult<IPage<CommunityThought>>().ok(pages);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public ResponseResult<CommunityThought> get(@PathVariable("id") Long id) {
        CommunityThought data = communityThoughtService.getById(id);
        return new ResponseResult<CommunityThought>().ok(data);
    }

    @PostMapping
    @Operation(summary = "新增")
    public ResponseResult save(@RequestBody CommunityThought entity) {

        communityThoughtService.save(entity);

        return new ResponseResult();
    }

}
