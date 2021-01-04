package com.ffcs.timestatistics.dao;

import com.ffcs.timestatistics.entity.EngineeWorkload;
import com.ffcs.timestatistics.entity.Timestatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Timestatistics)表数据库访问层
 *
 * @author xuqy
 * @since 2020-12-21 17:55:35
 */
@Mapper
@Repository
public interface TimestatisticsDao {


    /**
     * 查询所有开发者
     * @return
     */
    List<String> queryDeveloper();
    /**
     * 根据开发者查询工程点以及该工程点的总工作量
     * @param developer
     * @return
     */
    List<EngineeWorkload> queryWorkload(@Param("developer")String developer);

    /**
     * 显示全部
     * @return
     */
    List<Timestatistics> query();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Timestatistics> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param timestatistics 实例对象
     * @return 对象列表
     */
    List<Timestatistics> queryAll(Timestatistics timestatistics);

    /**
     * 新增数据
     *
     * @param timestatistics 实例对象
     * @return 影响行数
     */
    int insert(Timestatistics timestatistics);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Timestatistics> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Timestatistics> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Timestatistics> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Timestatistics> entities);

    /**
     * 修改数据
     *
     * @param timestatistics 实例对象
     * @return 影响行数
     */
    int update(Timestatistics timestatistics);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Timestatistics> queryByGroup(String group);
}
