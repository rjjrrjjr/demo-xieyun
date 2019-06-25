package com.rj.toj;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ruanj on 2019/6/15.
 */
@Data
public class OrderSkuServerLogDO implements Serializable {
    //自增ID
    private Long id;
    //订单号
    private Long mainOrderId;
    //子订单ID
    private Long childOrderId;
    //sku售后申请id
    private Long skuServerId;
    //操作前状态
    private Long beforeStatus;
    //操作后状态
    private Long afterStatus;
    //0-前后台展现;10:仅后台
    private Integer showType;
    //备注
    private String info;
    //操作人
    private String operator;
    //状态(0-关闭，1-开启)
    private Integer status;
    //创建时间
    private Long createTime;
    //添加用户
    private Long create_uid;
    //修改时间
    private Long modifyTime;
    //操作人
    private Long modifyUid;
    //操作人
    private Integer isDelete;
}
