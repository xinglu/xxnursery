package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 通用参数
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DBDataParam {
    String table_flag;//表名
    String param1;
    String param2;
}
