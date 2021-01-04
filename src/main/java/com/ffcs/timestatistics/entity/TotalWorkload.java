package com.ffcs.timestatistics.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
public class TotalWorkload implements Serializable {

    private String developer;       //开发者

    private List<EngineeWorkload> engineeWorkloadList;

    private HashMap<String, String> workLoad = new HashMap<>();

}
