//package com.rj.elasticjob;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.rj.canal.CanalReal;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
///**
// *
// */
//
//@Component
//public class Crowd2DevopsAuto implements SimpleJob {
//
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "================================sync user from crowd to devops begin");
//        CanalReal.neveDieGetMysqlDB();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "================================sync user from crowd to devops end");
//    }
//}
