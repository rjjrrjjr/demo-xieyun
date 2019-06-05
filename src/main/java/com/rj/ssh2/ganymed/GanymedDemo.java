package com.rj.ssh2.ganymed;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.Session;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ruanj on 2019/6/5.
 */
public class GanymedDemo {

    private static final String HOST = "192.168.33.12";
    private static final String USERNAME = "vagrant";
    private static final String PASSWORD = "vagrant";


    public static void main(String[] args) throws IOException {
        Connection connection = new Connection(HOST);
        connection.connect();
        //boolean authenticate = connection.authenticateWithPassword(USERNAME, PASSWORD);
        boolean authenticate = connection.authenticateWithPublicKey(USERNAME, new File("C:\\sys\\k8s\\work-node2\\.vagrant\\machines\\default\\virtualbox\\private_key"), "");
        if (!authenticate){
            throw new IOException("ERROR: authenticate failed");
        }
        Session session = connection.openSession();

        //打印服务器基本信息
        session.execCommand("uname -a && who && pwd");
        System.out.println("Here is some information about remote host");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(session.getStdout()));
        String temp;
        while ((temp = bufferedReader.readLine()) != null){
            System.out.println(temp);
        }
        bufferedReader.close();

        //文件及文件夹删除操作
        SFTPv3Client sftPv3Client = new SFTPv3Client(connection);
        sftPv3Client.createFile("test2.txt");
        sftPv3Client.rm("test2.txt");
        sftPv3Client.close();

        //文件上传下载
        SCPClient scpClient = new SCPClient(connection);
        scpClient.get("~/test.txt", "D:/");
        scpClient.put("D:/mysql_install", "~/");

        System.out.println("Exit code: " +  session.getExitSignal());
        session.close();
        connection.close();
    }
}
