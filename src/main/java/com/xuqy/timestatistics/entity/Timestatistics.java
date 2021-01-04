package com.xuqy.timestatistics.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Timestatistics)实体类
 *
 * @author xuqy
 * @since 2020-12-21 17:55:33
 */
@Data
public class Timestatistics implements Serializable {
    private static final long serialVersionUID = 296415944527856253L;

    private Integer id;

    private String developer;

    private String servNo;

    private String engineePoint;

    private String title;

    private String status;

    private String type;

    private String content;

    private String beginTime;

    private String endTime;

    private String workLoad;

    private String remarks;

    private String group;

}
