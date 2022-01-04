package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.Skill;
import com.jykj.user.entity.TaskInfo;
import com.jykj.user.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-12-02
 */
@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private ISkillService service;
    @GetMapping("/info/{type}")
    public CommonResult<String> getSkillContent(@PathVariable int type){
        Skill content = service.getSkillContentByType(type);
        if(!StringUtils.isEmpty(content)){
            return CommonResult.success(content.getSkillContent());
        }
        return CommonResult.failed();
    }
}
