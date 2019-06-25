package com.rj.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author ruanjin
 * @since 2019/6/20 10:53
 */
public class DemoIp {

    public static void main(String[] args) {
        InetAddress ia = null;
        try {
            ia = ia.getLocalHost();

            String localname = ia.getHostName();
            String localip = ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
            System.out.println("===========================" + InetAddress.getLocalHost().getHostAddress());
            System.out.println("---------------------------");
            System.out.println(getLocalIPList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                        String ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
    }
}
