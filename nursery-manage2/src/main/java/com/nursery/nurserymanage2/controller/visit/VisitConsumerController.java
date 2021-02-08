package com.nursery.nurserymanage2.controller.visit;

import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.api.iwebm.visit.VisitConsumerApi;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.beans.code.ConsumerCode;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.model.response.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/7 | Time:10:20
 * 个人中心
 */
@RestController()
@RequestMapping("/manage/consumer")
public class VisitConsumerController implements VisitConsumerApi {
    private Logger logger = LoggerFactory.getLogger(VisitConsumerController.class);

    @Autowired
    private IDomesticConsumerSV domesticConsumerSV;

    @RequestMapping(value = "/visit",method = RequestMethod.GET)
    @Override
    public ModelAndView visitConsumerPage() {
        QueryResponseResult data = new QueryResponseResult(CommonCode.FAIL, null);
        ModelAndView modelAndView = new ModelAndView();
        try {
            //分页
//            PageHelper.startPage(pageNum, pageSize);
            List<DomesticConsumerDO> consumerDOList = domesticConsumerSV.selectConsumers();

            if (consumerDOList != null && !consumerDOList.isEmpty()) {
                QueryResult<DomesticConsumerDO> queryResult = new QueryResult<>();
                queryResult.setList(consumerDOList);
                queryResult.setTotal(consumerDOList.size());
                data.setQueryResult(queryResult);
                logger.info("visitConsumerPage: consumerDOList ==> "+JSON.toJSONString(consumerDOList));
            } else {
                data.setCommonCode(ConsumerCode.CONSUMER_SELECT_LIST_ISNULL);
            }
        } catch (Exception e) {
            data.setCommonCode(ConsumerCode.CONSUMER_SQL_SELECT_FAIL);
        }
        data.setCommonCode(CommonCode.SUCCESS);
        modelAndView.addObject("data", data);
        modelAndView.setViewName("consumerManagePage");
        logger.info("visitConsumerPage: data ==> "+JSON.toJSONString(data));
        return modelAndView;
    }

    @RequestMapping(value = "/getConsumerInfo/{consumerID}",method = RequestMethod.GET)
    @Override
    public ModelAndView getConsumerInfoByID(@PathVariable("consumerID") String consumerID,ModelAndView modelAndView) {
        logger.info("VisitConsumerController: getConsumerInfoByID==>"+consumerID);
        QueryResponseResult data = new QueryResponseResult(CommonCode.FAIL, null);
        try {
           DomesticConsumerDO consumerDO = domesticConsumerSV.selectConsumerByConsumerID(consumerID);
           if (consumerDO!=null){
               QueryResult<DomesticConsumerDO> queryResult = new QueryResult<>();
               queryResult.setObject(consumerDO);
               data.setQueryResult(queryResult);
           }else {

           }
        }catch (Exception e){
            String localizedMessage = e.getLocalizedMessage();
            System.out.println(localizedMessage);
        }
        data.setCommonCode(CommonCode.SUCCESS);
        modelAndView.addObject("data", data);
        modelAndView.setViewName("consumerInfoPage");
        logger.info("getConsumerInfoByID: data ==> "+JSON.toJSONString(data));
        return modelAndView;
    }
}