
package top.continew.admin.webapi.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.util.ReUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.common.constant.RegexConstants;
import top.continew.admin.common.util.SecureUtils;
import top.continew.admin.generator.model.entity.FieldConfigDO;
import top.continew.admin.system.model.entity.CatLogDO;
import top.continew.admin.system.model.query.CatLogQuery;
import top.continew.admin.system.model.query.LogQuery;
import top.continew.admin.system.model.query.UserQuery;
import top.continew.admin.system.model.req.CatLogReq;
import top.continew.admin.system.model.req.UserPasswordResetReq;
import top.continew.admin.system.model.req.UserReq;
import top.continew.admin.system.model.req.UserRoleUpdateReq;
import top.continew.admin.system.model.resp.CatLogResp;
import top.continew.admin.system.model.resp.UserDetailResp;
import top.continew.admin.system.model.resp.UserResp;
import top.continew.admin.system.model.resp.log.LogResp;
import top.continew.admin.system.service.CatLogService;
import top.continew.admin.system.service.UserService;
import top.continew.starter.core.util.ExceptionUtils;
import top.continew.starter.core.util.validate.ValidationUtils;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.starter.extension.crud.enums.Api;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.extension.crud.util.ValidateGroup;
import top.continew.starter.web.model.R;

import java.util.List;

/**
 * 日志管理 API
 *
 * @author MaYanPing
 * @since 2023/2/20 21:00
 */
@Tag(name = "日志管理 API")
@Validated
@RestController
@CrudRequestMapping(value = "/catLog", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class CatLogController extends BaseController<CatLogService, CatLogResp, CatLogResp, CatLogQuery, CatLogReq> {

    @Operation(summary = "分页查询列表", description = "分页查询列表")
    @GetMapping("/page")
    public R<PageResp<CatLogResp>> page(CatLogQuery query, @Validated PageQuery pageQuery) {
        return R.ok(baseService.page(query, pageQuery));
    }

    @Operation(summary = "日志查询", description = "日志列表")
    @PostMapping("/querylist")
    public  R<List<CatLogDO>> getByLogList(@RequestBody CatLogReq catLogReq) {
        return R.ok(baseService.getByLogList(catLogReq));
    }


}
