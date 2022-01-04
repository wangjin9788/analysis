package com.jykj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.CompostingTaskParam;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.dto.vo.TaskRelationVo;
import com.jykj.user.entity.Fermentation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface FermentationMapper extends BaseMapper<Fermentation> {

    List<FermentationDataVo> getFermentationList(Page<FermentationDataVo> page, String year, String month);
    List<TaskRelationVo> getFerTaskNumberByType(@Param(value = "type")int type);
    CompostingTaskParam getCompostingTemperature(@Param(value = "id")long id);
    List<Long> getFerAllId();
}
