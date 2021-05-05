package com.jykj.user.common.utils;

import com.jykj.user.entity.Task;
import com.jykj.user.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Scheduler {
    @Autowired
    private ITaskService service;
    @Autowired
    private MailUtils mailUtils;
    //每隔2秒执行一次
    final static String ADDRESSEE = "980642298@qq.com";
    final static String title = "今天任务";

    @Scheduled(cron = "0 0 1 * * ?")
    public void testTasks() {
        List<Task> list = service.getSchedulerTaskList();
        StringBuffer buff = new StringBuffer();
        buff.append("<tr><td>时间</td><td>内容</td></tr>");
        boolean isSend=false;
        for (Task t : list) {
            isSend=true;
            buff.append("<tr><td>"+t.getTaskTime()+"</td><td>"+t.getTaskContent()+"</td></tr>");
        }

        if (isSend) {
            for (Task t: list) {
                t.setStatus(1);
                service.updateTask(t);
            }
            mailUtils.sendTemplateMail(ADDRESSEE, title, buff.toString(),"index.html");
        }
        System.out.println("定时任务执行时间：");
    }

}
