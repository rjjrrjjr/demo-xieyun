//package com.rj.elasticjob;
//
//import com.dangdang.ddframe.job.api.ElasticJob;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
///**
// *
// */
//@ConditionalOnClass(ZookeeperRegistryCenter.class)
//@Configuration
//@AutoConfigureAfter(ElasticAutoConfig.class)
//public class ElasticConfig {
//
//    @Resource
//    private ZookeeperRegistryCenter zookeeperRegistryCenter;
//
//    @Bean
//    public SimpleJob crowd2devops() {
//        return new Crowd2DevopsAuto();
//    }
//
//    @PostConstruct
//    public void initJobs() {
//        initSimpleJob("crowd2devops", "0 /1 * * * ? *", 1, crowd2devops());
//    }
//
//    private void initSimpleJob(final String jobName, final String cron, final int shardingTotalCount, ElasticJob elasticJob) {
//        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).build(), elasticJob.getClass().getCanonicalName());
//        LiteJobConfiguration jobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build();
//        new SpringJobScheduler(elasticJob, zookeeperRegistryCenter, jobConfiguration).init();
//    }
//}
