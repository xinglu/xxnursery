package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:11:18
 * 日志 tb_log_manage_时间  ||
 * 时间以季度分割  (1,2,3,4) 对应 {'0-3','3-6','6-9','9-12'}
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LogDO {
        private String classify;
        private String type;
        private String erId;
        private String dothing;
        private String id;
        private String logId;
        private String date;
        private String tableFlag;
}
