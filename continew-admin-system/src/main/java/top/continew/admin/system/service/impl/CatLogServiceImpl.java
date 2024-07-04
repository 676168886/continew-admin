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

package top.continew.admin.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.continew.admin.auth.service.OnlineUserService;
import top.continew.admin.common.constant.CacheConstants;
import top.continew.admin.common.constant.SysConstants;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.common.util.helper.LoginHelper;
import top.continew.admin.system.mapper.CatLogMapper;
import top.continew.admin.system.mapper.UserMapper;
import top.continew.admin.system.model.entity.*;
import top.continew.admin.system.model.query.CatLogQuery;
import top.continew.admin.system.model.query.UserQuery;
import top.continew.admin.system.model.req.*;
import top.continew.admin.system.model.resp.CatLogResp;
import top.continew.admin.system.model.resp.UserDetailResp;
import top.continew.admin.system.model.resp.UserResp;
import top.continew.admin.system.service.*;
import top.continew.starter.core.constant.StringConstants;
import top.continew.starter.core.util.validate.CheckUtils;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.query.SortQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.extension.crud.service.CommonUserService;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static top.continew.admin.system.enums.PasswordPolicyEnum.*;

/**
 * 用户业务实现
 *
 * @author Charles7c
 * @since 2022/12/21 21:49
 */
@Service
@RequiredArgsConstructor
public class CatLogServiceImpl extends BaseServiceImpl<CatLogMapper, CatLogDO, CatLogResp, CatLogResp, CatLogQuery, CatLogReq> implements CatLogService {

   // private final CatLogService catLogService;



    @Override
    public PageResp<CatLogResp> page(CatLogQuery query, PageQuery pageQuery) {
        QueryWrapper<CatLogDO> queryWrapper = this.buildQueryWrapper(query);
        IPage<CatLogResp> page = baseMapper.selectCatLogPage(pageQuery.toPage(), queryWrapper);
        PageResp<CatLogResp> pageResp = PageResp.build(page, this.listClass);
        pageResp.getList().forEach(this::fill);
        return pageResp;
    }

    @Override
    public List<CatLogDO> getByLogList(CatLogReq catLogReq) {
        List<CatLogDO> list = baseMapper.lambdaQuery()
                //输出的字段有那些
                .select(CatLogDO::getPatName, CatLogDO::getBusiness, CatLogDO::getPatId, CatLogDO::getPayMoney, CatLogDO::getPrintNum, CatLogDO::getJzcardNo,CatLogDO::getIdcardNo, CatLogDO::getId,CatLogDO::getPrintJsonStr,CatLogDO::getTransDate)
                //条件查询，=;
                .eq(CatLogDO::getPatName,catLogReq.getPat_name())
                .list();
        return list;
    }
}
