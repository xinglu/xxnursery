package com.nursery.nurserymanage2;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:15:55
 */
public class Java02 {

    public static void main(String[] args) {
        add();
//        drop();
    }
    public static void add(){
        String[] provs = new String[]{
                "100",
                "200",
                "210",
                "220",
                "230",
                "240",
                "250",
                "270",
                "280",
                "290",
                "300",
                "311",
                "351",
                "371",
                "431",
                "451",
                "471",
                "531",
                "550",
                "551",
                "571",
                "591",
                "731",
                "771",
                "791",
                "851",
                "871",
                "891",
                "898",
                "931",
                "951",
                "971",
                "991"};
        int count = 0;
        for (String prov: provs) {
            for (int i = 1; i <= 12; i++) {
                String sql = "";
                if(i<10){
                    sql = "ALTER TABLE `t_reg_rgsh_prov_inter_log_"+prov+"_20210"+i+"` MODIFY COLUMN  `CUT_PORTRT_PATH_BAK` VARCHAR (255) COMMENT 'rgsh选择图片后，备份cutPortrtStoinPath原始值';";
                }else{
                    sql = "ALTER TABLE `t_reg_rgsh_prov_inter_log_"+prov+"_2021"+i+"` MODIFY COLUMN  `CUT_PORTRT_PATH_BAK` VARCHAR (255) COMMENT 'rgsh选择图片后，备份cutPortrtStoinPath原始值';";
                }
                count++;
                System.out.println(sql);
            }
        }
        System.out.println("一共 " +count + "条");
    }
    public static void drop(){
        String[] provs = new String[]{
                "100",
                "200",
                "210",
                "220",
                "230",
                "240",
                "250",
                "270",
                "280",
                "290",
                "300",
                "311",
                "351",
                "371",
                "431",
                "451",
                "471",
                "531",
                "550",
                "551",
                "571",
                "591",
                "731",
                "771",
                "791",
                "851",
                "871",
                "891",
                "898",
                "931",
                "951",
                "971",
                "991"};
        String s = "ALTER TABLE `t_reg_rgsh_prov_inter_log_100_202101` DROP COLUMN `PDF_PIC_PATH`;";
        int count = 0;
        for (String prov: provs) {
            for (int i = 1; i <= 12; i++) {
                String sql = "";
                if(i<10){
                    sql = "ALTER TABLE `t_reg_rgsh_prov_inter_log_"+prov+"_20210"+i+"` DROP COLUMN `CALL_PHONE`;";
                }else{
                    sql = "ALTER TABLE `t_reg_rgsh_prov_inter_log_"+prov+"_2021"+i+"` DROP COLUMN `CALL_PHONE`;";
                }
                count++;
                System.out.println(sql);
            }
        }
        System.out.println("一共 " +count + "条");
    }
}
