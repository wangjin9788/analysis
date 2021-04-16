package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.entity.*;
import com.jykj.user.mapper.UmsRoleMapper;
import com.jykj.user.mapper.UmsRoleMenuRelationMapper;
import com.jykj.user.mapper.UmsRoleResourceRelationMapper;
import com.jykj.user.service.IUmsRoleService;
import com.jykj.user.service.UmsAdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-03
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements IUmsRoleService {

    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private UmsAdminCacheService adminCacheService;
    @Override
    public int create(UmsRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return baseMapper.insert(role);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return baseMapper.updateById(role);
    }

    @Override
    public int delete(List<Long> ids) {
        int count =baseMapper.deleteBatchIds(ids);
        adminCacheService.delResourceListByRoleIds(ids);
        return count;
    }

    @Override
    public List<UmsRole> list() {
        return baseMapper.selectList(new QueryWrapper<UmsRole>());
    }

    @Override
    public Page<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        QueryWrapper<UmsRole> query = new QueryWrapper<>();
        Page<UmsRole> page = new Page(pageNum, pageSize);
        if (!StringUtils.isEmpty(keyword)) {
            query.like("name",'%' + keyword + '%');
        }
        return baseMapper.selectPage(page,query);
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return baseMapper.getMenuList(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return baseMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return baseMapper.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        QueryWrapper<UmsRoleMenuRelation> delete = new QueryWrapper<>();
        delete.eq("role_id",roleId);
        roleMenuRelationMapper.delete(delete);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        QueryWrapper<UmsRoleResourceRelation> delete = new QueryWrapper<>();
        delete.eq("role_id",roleId);
        roleResourceRelationMapper.delete(delete);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }
}
