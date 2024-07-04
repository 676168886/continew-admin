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

package top.continew.admin.system.model.resp;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.core.executor.handler.ManyToManyAssembleOperationHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.constant.ContainerConstants;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.common.enums.GenderEnum;
import top.continew.admin.common.util.helper.LoginHelper;
import top.continew.starter.extension.crud.model.resp.BaseDetailResp;
import top.continew.starter.security.mask.annotation.JsonMask;
import top.continew.starter.security.mask.enums.MaskType;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * 终端日志查询
 * @author MaYanPing
 * @since 2024/6/20 21:08
 */
@Data
@Schema(description = "日志详情")
public class CatLogResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 日志记录ID
     */
    @Schema(description = "日志ID", example = "24")
    private BigInteger id;

    /**
     * 日志数据
     */
    @Schema(description = "交易JSON", example = "{\"deptName\":\"中医科门诊\",\"registeredDate\":\"2023-12-22\",\"patName\":\"黄傲珈\",\"registBc\":\"下午\",\"orderSum\":\"0.00\",\"operator\":\"自助机7002\",\"registLb\":\"普通\",\"docName\":\"郑惠萍\",\"mdtrtTime\":\"\",\"transDate\":\"2023-12-22\",\"payName\":\"医保\",\"sumType\":\"医保\",\"noCost\":\"12.00\",\"serialNumber\":\"3\",\"usePatientId\":\"12466074\",\"totalOrderSum\":\"12.00\",\"business\":\"挂号\",\"patSex\":\"男\",\"yhCost\":\"0.00\",\"hisUseCardNo\":\"0177694\",\"croomName\":\"\",\"patAge\":\"15岁\",\"patAddress\":\"\",\"mtczf\":\"12.00\",\"mzhzf\":\"12.00\"}")
    private String print_jsonstr;

    /**
     * 交易名称
     */
    //@Schema(description = "性别（0：未知；1：男；2：女）", type = "Integer", allowableValues = {"0", "1", "2"}, example = "1")
    @Schema(description = "交易名称", example = "挂号")
    private String business;

    /**
     * 就诊卡号
     */
    @Schema(description = "就诊卡号", example = "676166666")
    private String jzcard_no;

    /**
     * 身份证
     */
    @Schema(description = "身份证", example = "510110022444745")
    @JsonMask(MaskType.ID_CARD)
    private String idcard_no;

    /**
     * 病人id
     */
    @Schema(description = "病人id", example = "122540221")
    private String pat_id;

    /**
     * 病人id
     */
    @Schema(description = "病人姓名", example = "嘻嘻哈")
    private String pat_name;

    /**
     * 交易时间
     */
    @Schema(description = "交易时间", example = "2024-06-21 15:20:15")
    private String trans_date;

    /**
     * 支付金额
     */
    @Schema(description = "支付金额", example = "15.54")
    private String pay_money;

    /**
     * 打印次数
     */
    @Schema(description = "打印次数", example = "0")
    private Integer print_num;


}
