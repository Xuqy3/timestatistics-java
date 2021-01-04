package com.xuqy.timestatistics.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EngineeWorkload implements Serializable {

    private String engineePoint;

    private Integer totalWorkload;

}
