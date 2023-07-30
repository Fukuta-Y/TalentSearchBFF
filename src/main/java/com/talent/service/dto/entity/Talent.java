package com.talent.service.dto.entity;
import java.io.Serializable;

import lombok.Data;

/**
 *　タレント情報DTO
 */
@Data
public class Talent implements Serializable {
    private String id;
    private String name;
}