package com.rj.apm;

import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruanjin
 * @since 2019/5/16 15:51
 */
public class LoginApmHttpClient {

    public static void main(String[] args) throws IOException {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        //Referer:
        HttpPost httpPost = new HttpPost("http://apm.harmonycloud.com:9900/SysUser/Syslogin");

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("userName", "Kevin"));
        list.add(new BasicNameValuePair("password", "123456"));

        httpPost.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        Header[] allHeaders = httpResponse.getAllHeaders();
        Header[] cookies = httpResponse.getHeaders("Set-Cookie");

        httpResponse.close();
        httpClient.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", String.valueOf(cookies[0]));

        HttpEntity<User> requestEntity = new HttpEntity<>(new User().setUserName("Kevin").setPassword("123456"), headers);
        ResponseEntity<com.alibaba.fastjson.JSONObject> responseEntity =
                new RestTemplate().exchange("http://apm.harmonycloud.com:9900/SysUser/Syslogin", HttpMethod.POST, requestEntity, com.alibaba.fastjson.JSONObject.class);

        System.out.println(responseEntity.getBody().toJSONString());
    }
}
