package com.nursery.dao;

/**
 * author:MeiShiQiang
 * Date:2021/2/7 | Time:17:33
 * tb_consumerimage
 */
public interface ConsumerImageMapper {

    String selectImageUrlByImageId(String imageId)throws Exception;

}
