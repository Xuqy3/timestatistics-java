package com.xuqy.timestatistics.service;

import com.xuqy.timestatistics.entity.EngineeWorkload;
import com.xuqy.timestatistics.entity.Timestatistics;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Timestatistics)表服务接口
 *
 * @author xuqy
 * @since 2020-12-21 17:55:35
 */
@Component
public interface ITimestatisticsService {

    /**
     * 查询全部
     * @return
     */
    List<Timestatistics> query();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param timestatistics 实例对象
     * @return 对象列表
     */
    List<Timestatistics> queryAll(Timestatistics timestatistics);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Timestatistics> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param timestatistics 实例对象
     * @return 实例对象
     */
    Timestatistics insert(Timestatistics timestatistics);

    /**
     * 修改数据
     *
     * @param timestatistics 实例对象
     * @return 实例对象
     */
    Timestatistics update(Timestatistics timestatistics);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    void insertOrUpdateBatch(Timestatistics timestatistics);

    List<Timestatistics> search(Timestatistics timestatistics);

    List<Timestatistics> queryByGroup(String group);

    List<String> getDevelopers();

    List<EngineeWorkload> queryWorkload(String developer);
}
