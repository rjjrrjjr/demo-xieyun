package com.rj.crowd;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yiqun
 * @since 2019/4/23 11:46
 */
public class LoginIn {

    public static void main(String[] args) throws IOException {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        //Referer:
        HttpPost httpPost = new HttpPost("http://crowd.harmonycloud.com:8095/crowd/console/login.action");

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("j_username", "admin"));
        list.add(new BasicNameValuePair("j_password", "123456"));

        httpPost.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        Header[] allHeaders = httpResponse.getAllHeaders();
        Header[] cookies = httpResponse.getHeaders("Set-Cookie");

        httpResponse.close();
        httpClient.close();
    }

}
