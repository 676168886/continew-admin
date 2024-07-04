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

package top.continew.admin.auth.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import top.continew.admin.common.model.dto.LoginUser;
import top.continew.admin.common.util.helper.LoginHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Sa-Token 权限认证实现
 *
 * @author Charles7c
 * @since 2023/3/1 22:28
 */
public class SaTokenPermissionImpl implements StpInterface {

    /**
     * * @param loginId 登录用户的标识，可以是用户的ID或其他唯一标识符。
     *  * @param loginType 登录用户的类型，用于区分不同类型的用户或认证方式。
     *  * @return 返回一个包含登录用户所有权限的字符串列表。
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 通过登录帮助类获取当前登录的用户对象
        LoginUser loginUser = LoginHelper.getLoginUser();
        // 初始化并返回一个包含用户权限的列表
        return new ArrayList<>(loginUser.getPermissions());
    }

    /**
     * * @param loginId 用户的登录ID，用于标识用户。具体的类型取决于登录系统的实现，可以是字符串、数字等。
     *  * @param loginType 用户的登录类型，用于区分不同的登录方式。例如，可以是“用户名密码”、“手机验证码”等。
     *  * @return 返回一个包含用户角色代码的列表。每个角色都有一个唯一的代码。
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 通过LoginHelper获取当前登录的用户信息。
        LoginUser loginUser = LoginHelper.getLoginUser();
        // 初始化并返回一个包含用户角色代码的ArrayList。
        return new ArrayList<>(loginUser.getRoleCodes());
    }
}
