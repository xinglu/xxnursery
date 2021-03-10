package com.nursery.beans.code;

import com.google.common.collect.ImmutableMap;
import com.nursery.common.model.response.ResultCode;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/3 | Time:16:45
 * 通告
 */
@ToString
public enum AnnounceCode implements ResultCode {

    ANNOUNCE_SQL_Fail(false,23000,"数据库插入失败！"),
    ANNOUNCE_SQL_SUCCEED(true,23001,"通告信息更新成功！"),
    ANNOUNCE_SQL_FAIL(false,23002,"通告信息操作数据库错误！"),
    ANNOUNCE_PARAM_NONE(false,23003,"请传入正确的参数信息！"),
    ANNOUNCE_DELETE_SUCCESS(true,23004,"删除成功！"),
    ANNOUNCE_SERVER_FAIL(false,23005,"服务器出错！"),
    ANNOUNCE_GET_ID_ISNULL(false,23010,"获取id失败！服务器异常");

    boolean success;

    int code;

    String message;

    AnnounceCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private static final ImmutableMap<Integer, AnnounceCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, AnnounceCode> builder = ImmutableMap.builder();
        for (AnnounceCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
