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

package top.continew.admin.system.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.config.mybatis.BCryptEncryptor;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.common.enums.GenderEnum;
import top.continew.starter.extension.crud.model.entity.BaseDO;
import top.continew.starter.security.crypto.annotation.FieldEncrypt;
import top.continew.starter.security.mask.annotation.JsonMask;
import top.continew.starter.security.mask.enums.MaskType;

import java.io.Serial;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 用户实体
 *方法一：可以使用@TableField注解，指定数据库表字段名； 如果字段显示null 后用此注解
 *
 * 方法二：在配置文件中配置mybaitis-plus，关闭自动驼峰命名规则映射：
 * @author Charles7c
 * @since 2022/12/21 20:42
 */
@Data
@TableName("t_print_receipt")
public class CatLogDO extends BaseDO {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 日志记录ID
     */
    @TableField(value = "id")
    private Long id;
    /**
     * 日志数据
     */
    @TableField(value = "print_jsonstr")
    private String printJsonStr;
    /**
     * 交易名称
     */
    private String business;
    /**
     * 就诊卡号
     */
    @TableField(value = "jzcard_no")
    private String jzcardNo;
    /**
     * 身份证
     */
    @TableField("idcard_no")
    private String idcardNo;
    /**
     * 病人id
     */
    @TableField(value = "pat_id")
    private String patId;
    /**
     * 病人名称
     */
    @TableField(value = "pat_name")
    private String patName;
    /**
     * 交易时间
     */
    @TableField(value = "trans_date")
    private String transDate;
    /**
     * 支付金额
     */
    @TableField(value = "pay_money")
    private String payMoney;
    /**
     * 打印次数
     */
    @TableField(value = "print_num")
    private Integer printNum;


}
