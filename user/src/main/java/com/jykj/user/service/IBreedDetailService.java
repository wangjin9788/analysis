package com.jykj.user.service;

import com.jykj.user.dto.BatchDetailParam;
import com.jykj.user.dto.vo.BreedChartVo;
import com.jykj.user.dto.vo.BreedDetailVo;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.BreedDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface IBreedDetailService extends IService<BreedDetail> {
    int createBreedDetail(BreedDetail breed);

    int updateBreedDetail(BreedDetail breed);

    List<BreedDetailVo> getBreedDetailList(long bid, Integer pageSize, Integer pageNum);

    BreedDetail getBreedDetailById(long id);

    Integer deleteBreedDetail(long id);

    int batchBreedDetail(List<BatchDetailParam> batchList);

    List<BreedChartVo>getBreedChartTemperature(long id);
}
