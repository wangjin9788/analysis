package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.dto.CompostingTaskParam;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.mapper.FermentationDetailMapper;
import com.jykj.user.mapper.FermentationMapper;
import com.jykj.user.mapper.TaskMapper;
import com.jykj.user.service.IFermentationService;
import com.jykj.user.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
@Service
public class FermentationServiceImpl extends ServiceImpl<FermentationMapper, Fermentation> implements IFermentationService {
    @Autowired
    private ITaskService taskService;

    @Autowired
    private FermentationDetailMapper detailMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int createFermentation(Fermentation fermentation) throws ParseException {
        fermentation.setCreateTime(LocalDateTime.now());
        int index = baseMapper.insert(fermentation);
        if (index > 0&& fermentation.getType()>1) {
            //菌种发酵
            taskService.handleTaskByType(fermentation.getFid(), fermentation.getType(), fermentation.getNumber());
        }
        return index;
    }

    @Override
    public int updateFermentation(Fermentation fermentation) {
        return baseMapper.updateById(fermentation);
    }

    @Override
    public List<FermentationDataVo> getFermentationList(String year, String month, Integer pageSize, Integer pageNum) {
        Page<FermentationDataVo> page = new Page<>(pageNum, pageSize);
        List<FermentationDataVo> list = baseMapper.getFermentationList(page, year, month);
        return list;
    }

    @Override
    public Fermentation getFermentationById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int deleteFermentation(long fid) {
        int i = baseMapper.deleteById(fid);
        if(i>0){
            Map<String,Object> map = new HashMap<>();
            map.put("fid",fid);
            detailMapper.deleteByMap(map);
            Map<String,Object> map1 = new HashMap<>();
            map1.put("contact_id",fid);
            map1.put("type",1);
            taskMapper.deleteByMap(map1);
            Map<String,Object> map2 = new HashMap<>();
            map2.put("contact_id",fid);
            map2.put("type",6);
            taskMapper.deleteByMap(map2);
        }

        return i;
    }

    @Override
    public int updateFermentationAndSummary(long id) {

        Fermentation fermentation = baseMapper.selectById(id);
        if (fermentation != null && fermentation.getStatus() == 1) {
            return 1;
        }
        fermentation.setStatus(1);

        //修改状态为完成
        int count = baseMapper.updateById(fermentation);
        return count;
        //建一张总结表，将数据进行整理
    }
    /**
     * 定时堆沤任务
     * @param id
     * @return
     */
    @Override
    public CompostingTaskParam getCompostingTemperature(long id) {
        return baseMapper.getCompostingTemperature(id);
    }
    @Override
    public List<Long> getFerAllId() {
        return baseMapper.getFerAllId();
    }
}
