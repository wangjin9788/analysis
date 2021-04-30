package com.jykj.user.service;

import com.jykj.user.entity.BreedOperation;
import com.jykj.user.entity.BreedPathology;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-30
 */
public interface IBreedPathologyService extends IService<BreedPathology> {
    int create(BreedPathology breed);

    int update(BreedPathology breed);

    int delete(long id);

    List<BreedPathology> search(String keyWod, Integer pageSize, Integer pageNum);

    BreedPathology getBreedPathologyById(long id);
}
