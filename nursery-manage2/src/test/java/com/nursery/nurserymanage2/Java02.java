package com.nursery.nurserymanage2;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:15:55
 */
public class Java02 {

    @Test
    public void datejidu9(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String yearMonth = simpleDateFormat.format(date);
        String year = yearMonth.substring(0, 4);
        String month = yearMonth.substring(5, 7);
        int intMonth = Integer.parseInt(month);
        int quarter = intMonth % 3 == 0 ? intMonth/3 : intMonth/3+1;
        System.out.println(year+"_"+quarter);
    }
}
