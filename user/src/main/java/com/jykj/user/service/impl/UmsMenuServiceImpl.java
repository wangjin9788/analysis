package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.UmsMenuNode;
import com.jykj.user.entity.UmsAdmin;
import com.jykj.user.entity.UmsMenu;
import com.jykj.user.mapper.UmsMenuMapper;
import com.jykj.user.service.IUmsMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-04
 */
@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements IUmsMenuService {


    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return baseMapper.insert(umsMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenu parentMenu = baseMapper.selectById(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
        return baseMapper.updateById(umsMenu);
    }

    @Override
    public UmsMenu getItem(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Page<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        QueryWrapper<UmsMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",parentId);
        Page<UmsMenu> page = new Page<>(pageNum, pageSize);

        return baseMapper.selectPage(page,wrapper);
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = baseMapper.selectList(new QueryWrapper<>());
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return baseMapper.updateById(umsMenu);
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
