/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.system.model.req;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.lang.RegexPool;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import top.continew.admin.common.constant.RegexConstants;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.common.enums.GenderEnum;
import top.continew.starter.extension.crud.model.req.BaseReq;
import top.continew.starter.extension.crud.util.ValidateGroup;

import java.io.Serial;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 查询日志记录数据
 *
 * @author Charles7c
 * @since 2023/2/20 21:03
 */
@Data
@Schema(description = "查询日志记录数据")
public class CatLogReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关键词
     */
    @Schema(description = "日志ID", example = "25")
    private Long id;

    /**
     * 状态
     */
    @Schema(description = "交易名称", example = "挂号")
    private String business;

    /**
     * 交易时间
     */
    @Schema(description = "交易时间", example = "2023-08-08 00:00:00,2023-08-08 23:59:59")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @Size(max = 2, message = "交易时间必须是一个范围")
    private List<Date> trans_date;

    /**
     * 就诊卡号
     */
    @Schema(description = "就诊卡号", example = "1")
    private String jzcard_no;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号", example = "1")
    private String idcard_no;

    /**
     * 就诊卡号
     */
    @Schema(description = "就诊卡号", example = "1")
    private String pat_id;

    /**
     * 病人名称
     */
    @Schema(description = "病人名称", example = "zhangsan")
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = RegexConstants.USERNAME, message = "用户名长度为 4-64 个字符，支持大小写字母、数字、下划线，以字母开头")
    private String pat_name;

    /**
     * 交易金额
     */
    @Schema(description = "交易金额", example = "1")
    private Integer print_num;

}
