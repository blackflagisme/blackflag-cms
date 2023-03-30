package com.blackflag.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author blackflagisme zhengclfy@qq.com
 */
@Schema(name = "社区想法")
@Data
public class CommunityThought {

    @TableId
    private String id;

    private String title;

    private String content;

}
