//package com.rj.elasticjob;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * elasticJob
// */
//@Configuration
//@ConditionalOnClass(ShardingContext.class)
//public class ElasticAutoConfig {
//
//    @Value("${elasticjob.serverLists}")
//    private String serverLists;
//
//    @Value("${elasticjob.namespace}")
//    private String namespace;
//
//    @Bean
//    public ZookeeperConfiguration zkConfig(){
//        return new ZookeeperConfiguration(serverLists, namespace);
//    }
//
//    @Bean(initMethod = "init")
//    public ZookeeperRegistryCenter registryCenter(ZookeeperConfiguration zookeeperConfiguration){
//        return new ZookeeperRegistryCenter(zookeeperConfiguration);
//    }
//}
