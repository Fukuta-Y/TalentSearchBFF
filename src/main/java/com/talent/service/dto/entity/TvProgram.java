package com.talent.service.dto.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class TvProgram implements Serializable {
    private String id;
    private String name;
    private String onairDay;
}