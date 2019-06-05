package com.rj.crowd;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author yiqun
 * @since 2019/4/23 14:30
 */
public class PullGitlabUser {

    public static void main(String[] args) throws IOException {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://crowd.harmonycloud.com:8095/crowd/rest/usermanagement/1/search?entity-type=user");

        httpGet.setHeader("Authorization", "Basic " + new String(Base64.getEncoder().encode("gitlab:123456".getBytes())));
        httpGet.setHeader("Accept", "application/json");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        FileOutputStream fileOutputStream = new FileOutputStream("D:/centent.txt");
        entity.writeTo(fileOutputStream);
        fileOutputStream.close();
        httpResponse.close();
        httpClient.close();
    }
}
