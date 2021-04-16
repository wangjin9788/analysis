package com.jykj.user.mapper;

import com.jykj.user.entity.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jykj.user.entity.UmsPermission;
import com.jykj.user.entity.UmsResource;
import com.jykj.user.entity.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-03
 */
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
