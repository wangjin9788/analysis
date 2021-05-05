package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.entity.Task;
import com.jykj.user.service.IPayAnalysisService;
import com.jykj.user.service.ITaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/task")
@Api(tags = "ExpPayController", description = "任务管理")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    @ApiOperation("创建任务信息")
    @PostMapping("/create")
    public CommonResult createTask(@RequestBody Task task) {
        Integer count = taskService.createTask(task);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑任务信息")
    @PostMapping("/update")
    public CommonResult updateTask(@RequestBody Task task) {
        int count = taskService.updateTask(task);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取任务信息")
    @GetMapping("/list")
    public CommonResult<List<Task>> getTaskList(@RequestParam(value = "year", required = false) String year,
                                                                      @RequestParam(value = "month", required = false) String month,
                                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Task>  vo = taskService.getTaskList(year, month, pageSize, pageNum);
        return CommonResult.success(vo);
    }

    @ApiOperation("根据id获取任务信息")
    @GetMapping("/info/{id}")
    public CommonResult<Task> getTaskInfo(@PathVariable long id) {
        Task fermentationById = taskService.getTaskInfo(id);
        return CommonResult.success(fermentationById);
    }

    @ApiOperation("删除任务信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteTask(@PathVariable Long id) {
        Integer count = taskService.deleteTask(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
