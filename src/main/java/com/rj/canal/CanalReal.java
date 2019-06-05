package com.rj.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.rj.model.User;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yiqun
 * @since 2019/4/23 16:59
 */
public class CanalReal {

    private static final String hostName = "192.168.33.10";
    private static final Integer port = 11111;

    private static final String databaseName = "canal";
    private static final List<String> tableNames = Arrays.asList("user");

    public static void main(String args[]) {
        //调用通过canal获取DB数据同步
        neveDieGetMysqlDB();
    }

    public static void neveDieGetMysqlDB() {
        String destination = "example";
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(hostName, port), destination, "", "");
        int batchSize = 1000;
        connector.connect();
        connector.subscribe(".*\\..*");
        connector.rollback();
        Long batchId = null;
        try {
            // 获取指定数量的数据
            Message message = connector.getWithoutAck(batchSize);
            batchId = message.getId();
            int size = message.getEntries().size();
            if (batchId != -1 && size > 0) {
                printEntry(message.getEntries());
            }
            connector.ack(batchId); // 提交确认
        } catch (Exception e) {
            if (null != batchId) {
                connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
            connector.disconnect();
        }
    }

    private static void printEntry(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            if (!Objects.equals(entry.getHeader().getSchemaName(), databaseName) || !tableNames.contains(entry.getHeader().getTableName())){
                continue;
            }

            CanalEntry.RowChange rowChage;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }

            CanalEntry.EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));

            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                if (CanalEntry.EventType.DELETE.equals(eventType)) {
                    syncData(analysisRowData(rowData.getBeforeColumnsList()), eventType);
                }else {
                    syncData(analysisRowData(rowData.getAfterColumnsList()), eventType);
                }
            }
        }
    }

    private static void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

    private static <T> T analysisRowData(List<CanalEntry.Column> columns, Class<T> clazz) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T t = clazz.newInstance();
        for (CanalEntry.Column column : columns) {
            Field field = clazz.getDeclaredField(column.getName());
            if (field == null){
                continue;
            }
            field.setAccessible(true);
            field.set(t, column.getValue());
        }
        return t;
    }

    private static User analysisRowData(List<CanalEntry.Column> columns){
        if (columns == null || columns.size() == 0){
            return null;
        }
        User user = new User();
        Map<String, String> fieldName2Value = columns.stream().collect(Collectors.toMap(CanalEntry.Column::getName, CanalEntry.Column::getValue));
        user.setUsername(fieldName2Value.get("username"));
        user.setEmail(fieldName2Value.get("username"));
        return user;
    }

    public static void syncData(User user, CanalEntry.EventType eventType){
        System.out.println(eventType + "===============");
        System.out.println(user);
    }
}
