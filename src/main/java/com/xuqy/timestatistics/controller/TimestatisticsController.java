package com.xuqy.timestatistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.xuqy.timestatistics.entity.EngineeWorkload;
import com.xuqy.timestatistics.entity.Timestatistics;
import com.xuqy.timestatistics.entity.TotalWorkload;
import com.xuqy.timestatistics.lang.Result;
import com.xuqy.timestatistics.service.ITimestatisticsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Timestatistics)表控制层
 *
 * @author xuqy
 * @since 2020-12-21 17:55:36
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/timestatistics")
public class TimestatisticsController {
    /**
     * 服务对象
     */
    @Resource
    private ITimestatisticsService iTimestatisticsService;

    /**
     * 查询全部
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll(){
        return Result.succ(iTimestatisticsService.query());
    }
    /**
     * 分页查询
     * @return
     */
    @GetMapping("/getAllByPage/{pageNo}")
    public Result getAll(@PathVariable Integer pageNo){
        PageHelper.startPage(pageNo, 10);
        List<Timestatistics> timestatisticsList = iTimestatisticsService.query();

        PageInfo<Timestatistics> pageInfo = new PageInfo<>(timestatisticsList);
        return Result.succ(pageInfo);
    }

    /**
     * 新增数据
     * @param timestatistics
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Timestatistics timestatistics){
        iTimestatisticsService.insert(timestatistics);
        return Result.succ("提交成功");
    }

    /**
     * 条件搜索
     * @param timestatistics
     * @return
     */
    @PostMapping("/search")
    public Result serach(@RequestBody Timestatistics timestatistics){
        List<Timestatistics> timestatisticsList = iTimestatisticsService.search(timestatistics);
        return Result.succ(timestatisticsList);
    }

    /**
     * 根据id修改数据
     * @param timestatistics
     * @return
     */
    @PutMapping("/modifyById")
    public Result modify(@RequestBody Timestatistics timestatistics){
        iTimestatisticsService.update(timestatistics);
        return Result.succ("修改成功");
    }

    /**
     * 根据Id删除记录
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public Result delete(@PathVariable Integer id){
        iTimestatisticsService.deleteById(id);
        return Result.succ(iTimestatisticsService.query());
    }

    /**
     * 根据小组搜索
     * @param group
     * @return
     */
    @GetMapping("/search/{group}")
    public Result searchByGroup(@PathVariable String group){
        List<Timestatistics> timestatisticsList = iTimestatisticsService.queryByGroup(group);
        return Result.succ(timestatisticsList);
    }

    /**
     * 根据开发者搜索工作量
     * @return
     */
    @GetMapping("/getWorkload")
    public Result getWorkload(){

        List<String> developers = iTimestatisticsService.getDevelopers();
        List<TotalWorkload> totalWorkloads = new ArrayList();
        //用来存储所有array中的关于工作量的list
        List<Object> AllEngineeWorkloadList = new ArrayList<>();
        //根据集合中的所有开发人员去查询他们的工作量，并转换为HashMap，并将每个人关于工作量的engineeWorkloadMapper转为Object再放入AllEngineeWorkloadList
        for (int i=0;i<developers.size();i++){
            String developer = developers.get(i);
            TotalWorkload totalWorkload = new TotalWorkload();

            totalWorkload.setDeveloper(developer);

            List<EngineeWorkload> engineeWorkloads = iTimestatisticsService.queryWorkload(developer);

            //将工程点和工时转为Map类型
            HashMap<String, Object> engineeWorkloadMapper = new HashMap<String, Object>();
            for (EngineeWorkload engineeWorkload : engineeWorkloads) {
                engineeWorkloadMapper.put(engineeWorkload.getEngineePoint(), engineeWorkload.getTotalWorkload().toString());
                engineeWorkloadMapper.put("开发人员",developer);
            }
            JSONObject AllEngineeWorkload = new JSONObject(engineeWorkloadMapper);
            AllEngineeWorkloadList.add(AllEngineeWorkload);
            totalWorkload.setEngineeWorkloadList(engineeWorkloads);
//            totalWorkload.setWorkLoad(engineeWorkloadMapper);
            totalWorkloads.add(totalWorkload);
        }
//        log.debug(AllEngineeWorkloadMapper.toString());
//        JSONObject AllEngineeWorkload = new JSONObject(AllEngineeWorkloadMapper);
        return Result.succ(AllEngineeWorkloadList);
    }

}
