package com.jykj.user.common.utils;

import com.jykj.user.dto.CompostingTaskParam;
import com.jykj.user.entity.TaskInfo;
import com.jykj.user.service.IFermentationService;
import com.jykj.user.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Component
public class Scheduler {
    @Autowired
    private ITaskService service;
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private IFermentationService fer;

    final static String ADDRESSEE = "980642298@qq.com";
    final static String title = "今天任务";

    @Scheduled(cron = "0 0 1 * * ?")
    public void testTasks() {
        List<TaskInfo> list = service.getSchedulerTaskList();
        StringBuffer buff = new StringBuffer();
        buff.append("<html><body><table cellpadding=10><tr><td  width=300px>时间</td><td width=300px>内容</td></tr>");
        boolean isSend = false;
        for (TaskInfo t : list) {
            isSend = true;

            buff.append("<tr><td width=300px>" + t.getTaskTime() + "</td><td width=300px>" + t.getNumber() + t.getTaskContent() + "</td></tr>");
        }
        buff.append("</table></body></html>");
        if (isSend) {
            for (TaskInfo t : list) {
                t.setStatus(1);
                service.updateTask(t);
            }
        mailUtils.sendHtmlMail(ADDRESSEE, title, buff.toString());
        }
        System.out.println("定时任务执行时间：");
    }

    /**
     * 创建堆沤发酵数据
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void handleCompostingTask() throws ParseException {
        List<Long> ferAllId = fer.getFerAllId();
        for (long fid :
                ferAllId) {
            CompostingTaskParam data = fer.getCompostingTemperature(fid);
            if (data != null) {
                TaskInfo info = service.getNewTaskByType(data.getFid(), data.getType());
                if (info == null) {
                    //创建数据
                    service.handleTaskByType(data.getFid(), data.getType(), data.getNumber());
                }
            }
        }

    }
}
