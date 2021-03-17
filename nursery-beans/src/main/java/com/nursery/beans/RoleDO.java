package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * 权限表
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoleDO implements Serializable {

    private String id;
    private String name;
    private String role;

}
