package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *   `id` varchar(32) NOT NULL,
 *   `classify` varchar(64) DEFAULT NULL COMMENT '轮播图所属类',
 *   `slideName` varchar(64) DEFAULT NULL COMMENT '名字',
 *   `slidePath` varchar(128) DEFAULT NULL COMMENT '路径',
 *   `slideWidth` varchar(4) DEFAULT '0' COMMENT '宽度',
 *   `slideheight` varchar(4) DEFAULT '0' COMMENT '高度',
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SlideshowDO {
    private String id;
    private String classify;
    private String name;
    private String path;
    private String width;
    private String height;
}
