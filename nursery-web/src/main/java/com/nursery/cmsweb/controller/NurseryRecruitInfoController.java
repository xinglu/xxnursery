package com.nursery.cmsweb.controller;

import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.api.iweb.NurseryRecruitInfoApi;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.model.response.QueryResult;
import com.nursery.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * 幼儿园招聘信息controller
 */
@RestController
@RequestMapping("/nursery/recruit")
public class NurseryRecruitInfoController extends BaseController implements NurseryRecruitInfoApi {

    @Autowired
    private INurseryRecruitInfoSV nurseryRecruitInfoSV;

    /**
     * 招聘信息
     * @param classify  类型
     * @param tablename 名字
     * @return  统一参数
     */
    @GetMapping("/recruitList")
    @Override
//    @SuppressWarnings("unchecked")
    public QueryResponseResult recruitList(String classify, String tablename) {
        QueryResult<RecruitmentDO> queryResult = new QueryResult<>();
        DBDataParam dbDataParam = new DBDataParam();
        if (classify!=null){
            dbDataParam.setParam1(classify);
        }
        if (tablename!=null){
            tablename = "%"+tablename+"%";
            dbDataParam.setParam2(tablename);
        }

        try {
            List<RecruitmentDO> recruitmentList = nurseryRecruitInfoSV.recruitList(dbDataParam);
            if (recruitmentList!=null){
                queryResult.setList(recruitmentList);
                queryResult.setTotal(recruitmentList.size());
                return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new QueryResponseResult(CommonCode.FAIL,null);
    }

    /**
     * 热门招聘信息
     * @return 统一参数
     */
    @GetMapping("/hotRecruitlist")
    @Override
    public QueryResponseResult hotRecruitlist() {

        return null;
    }
}
