package com.rj.toj;

import com.alibaba.fastjson.JSON;

/**
 * Created by ruanj on 2019/6/15.
 */
public class Demo {

    public static void main(String[] args) {
        OrderSkuServerLogDO orderSkuServerLogDO = new OrderSkuServerLogDO();
        orderSkuServerLogDO.setAfterStatus(1L);
        orderSkuServerLogDO.setBeforeStatus(2L);
        orderSkuServerLogDO.setChildOrderId(1L);
        orderSkuServerLogDO.setCreate_uid(1L);
        orderSkuServerLogDO.setCreateTime(11L);
        orderSkuServerLogDO.setInfo("qwe");
        orderSkuServerLogDO.setIsDelete(1);
        orderSkuServerLogDO.setMainOrderId(1L);
        orderSkuServerLogDO.setModifyTime(22L);
        orderSkuServerLogDO.setModifyUid(2L);
        orderSkuServerLogDO.setShowType(3);
        orderSkuServerLogDO.setStatus(1);
        orderSkuServerLogDO.setSkuServerId(1L);

        System.out.println(JSON.toJSONString(orderSkuServerLogDO));
    }
}
