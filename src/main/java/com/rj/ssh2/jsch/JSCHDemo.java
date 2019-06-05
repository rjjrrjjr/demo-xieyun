package com.rj.ssh2.jsch;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.Properties;

/**https://github.com/gaoxingliang/JSch
 * Created by ruanj on 2019/6/5.
 */
public class JSCHDemo {

    private static JSch jSch;
    private static Session session;

    //执行命令
    private static String CHANNEL_EXEC = "exec";
    //文件处理
    private static String CHANNEL_SFTP = "sftp";

    public static void connect(String user, String password, String host, Integer port) throws JSchException {
        jSch = new JSch();
        session = jSch.getSession(user, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(1500);
        session.connect();
    }

    public static void disConnect(){
        session.disconnect();
    }

    public static void execCmd(String command) throws JSchException, IOException {
        ChannelExec execChannel = (ChannelExec) session.openChannel(CHANNEL_EXEC);
        execChannel.setCommand(command);
        execChannel.connect();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(execChannel.getInputStream()));
        String temp;
        while ((temp = bufferedReader.readLine()) != null){
            System.out.println(temp);
        }
        bufferedReader.close();
        execChannel.disconnect();
    }

    public static void upload(String directory, String uploadFile) throws JSchException, SftpException, FileNotFoundException {
        ChannelSftp sftpChannel = (ChannelSftp) session.openChannel(CHANNEL_SFTP);
        sftpChannel.connect();
        sftpChannel.cd(directory);
        File file = new File(uploadFile);
        sftpChannel.put(new FileInputStream(file), file.getName());
        System.out.println("upload success");
        sftpChannel.quit();
    }

    public static void download(String src, String dst) throws JSchException, SftpException {
        ChannelSftp sftpChannel = (ChannelSftp) session.openChannel(CHANNEL_SFTP);
        sftpChannel.connect();
        sftpChannel.get(src, dst);
        sftpChannel.quit();
    }

    public static void delete(String directory, String deleteFile) throws JSchException, SftpException {
        ChannelSftp sftpChannel = (ChannelSftp) session.openChannel(CHANNEL_SFTP);
        sftpChannel.connect();
        sftpChannel.cd(directory);
        sftpChannel.rm(deleteFile);
        sftpChannel.quit();
    }

    public static void list(String directory) throws JSchException, SftpException {
        ChannelSftp sftpChannel = (ChannelSftp) session.openChannel(CHANNEL_SFTP);
        sftpChannel.connect();
        sftpChannel.ls(directory).forEach(System.out::println);
        sftpChannel.quit();
    }

    public static void main(String[] args) throws JSchException, IOException, SftpException {
        connect("root", "123456", "192.168.142.128", 22);
        execCmd("pwd && who");
        //upload("/root", "D:/mysql_install");
        download("/root/mysql_install", "E:/");
        delete("/root", "mysql_install");
        list("/root");
        disConnect();
    }
}
