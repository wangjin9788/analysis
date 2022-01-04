package com.jykj.user.dto.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Data
public class TaskDictionaryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long tdId;

    /**
     * 任务内容
     */
    private String taskContent;

    /**
     * 类型（0：其他 1：翻堆 2：浇水）
     */
    private Integer type;

    /**
     * 时间间隔
     */
    private String intervalTime;

    private List<Integer> intervalList;


}
