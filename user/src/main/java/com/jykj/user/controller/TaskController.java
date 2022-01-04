package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.TaskRelationVo;
import com.jykj.user.entity.TaskInfo;
import com.jykj.user.service.ITaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public CommonResult createTask(@RequestBody TaskInfo task) {
        Integer count = taskService.createTask(task);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑任务信息")
    @PostMapping("/update")
    public CommonResult updateTask(@RequestBody TaskInfo task) {
        int count = taskService.updateTask(task);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取任务信息")
    @GetMapping("/list")
    public CommonResult<List<TaskInfo>> getTaskList(@RequestParam(value = "year", required = false) String year,
                                                    @RequestParam(value = "month", required = false) String month,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<TaskInfo>  vo = taskService.getTaskList(year, month, pageSize, pageNum);
        return CommonResult.success(vo);
    }

    @ApiOperation("根据id获取任务信息")
    @GetMapping("/info/{id}")
    public CommonResult<TaskInfo> getTaskInfo(@PathVariable long id) {
        TaskInfo fermentationById = taskService.getTaskInfo(id);
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
    @ApiOperation("修改任务状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult UpdateStatus(@PathVariable Long id) throws ParseException {
        Integer count = taskService.updateStatus(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据类型获取养殖发酵信息")
    @GetMapping("/relation/{type}")
    public CommonResult<List<TaskRelationVo>> getTaskInfo(@PathVariable int type) {
        List<TaskRelationVo> taskRelationList = taskService.getTaskRelationList(type);
        return CommonResult.success(taskRelationList);
    }

}
