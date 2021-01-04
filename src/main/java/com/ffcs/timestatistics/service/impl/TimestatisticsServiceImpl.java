package com.ffcs.timestatistics.service.impl;

import com.ffcs.timestatistics.dao.TimestatisticsDao;
import com.ffcs.timestatistics.entity.EngineeWorkload;
import com.ffcs.timestatistics.entity.Timestatistics;
import com.ffcs.timestatistics.service.ITimestatisticsService;
import com.ffcs.timestatistics.service.ITimestatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Timestatistics)表服务实现类
 *
 * @author xuqy
 * @since 2020-12-21 17:55:36
 */
@Service
public class TimestatisticsServiceImpl implements ITimestatisticsService {

    @Autowired
    private TimestatisticsDao timestatisticsDao;

    /**
     * 通过ID查询单条数据
     * @return 实例对象
     */
    @Override
    public List<Timestatistics> query() {
        return this.timestatisticsDao.query();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Timestatistics> queryAllByLimit(int offset, int limit) {
        return this.timestatisticsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param timestatistics 实例对象
     * @return 实例对象
     */
    @Override
    public Timestatistics insert(Timestatistics timestatistics) {
        this.timestatisticsDao.insert(timestatistics);
        return timestatistics;
    }

    /**
     * 修改数据
     *
     * @param timestatistics 实例对象
     * @return 实例对象
     */
    @Override
    public Timestatistics update(Timestatistics timestatistics) {
        this.timestatisticsDao.update(timestatistics);
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.timestatisticsDao.deleteById(id) > 0;
    }

    @Override
    public List<Timestatistics> queryAll(Timestatistics timestatistics) {
        return timestatisticsDao.queryAll(timestatistics);
    }

    /**
     * 批量新增或修改
     * @param timestatistics
     */
    @Override
    public void insertOrUpdateBatch(Timestatistics timestatistics) {
        List<Timestatistics> timestatisticsList = new ArrayList<>();
        timestatisticsList.add(timestatistics);
        timestatisticsDao.insertOrUpdateBatch(timestatisticsList);
    }

    /**
     * 查询
     * @param timestatistics
     * @return
     */
    @Override
    public List<Timestatistics> search(Timestatistics timestatistics) {
        return timestatisticsDao.queryAll(timestatistics);
    }

    @Override
    public List<Timestatistics> queryByGroup(String group) {
        return timestatisticsDao.queryByGroup(group);
    }

    @Override
    public List<String> getDevelopers() {
        return timestatisticsDao.queryDeveloper();
    }

    @Override
    public List<EngineeWorkload> queryWorkload(String developer) {
        return timestatisticsDao.queryWorkload(developer);
    }
}
