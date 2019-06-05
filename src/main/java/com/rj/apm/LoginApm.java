package com.rj.apm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruanjin
 * @since 2019/5/16 13:51
 */
public class LoginApm {

    public static void main(String[] args) {
        HashMap<String, Object> kevinMap = new HashMap<>();
        kevinMap.put("userName", "Kevin");
        kevinMap.put("password", "123456");

        RestTemplate restTemplate = new RestTemplate();

        Object o;
        try {
            o = restTemplate.postForObject("http://apm.harmonycloud.com:9900/SysUser/Syslogin", kevinMap, Object.class);
        } catch (Exception e) {
            try {
                o = restTemplate.postForObject("http://apm.harmonycloud.com:9900/SysUser/Syslogin", kevinMap, Object.class);
            } catch (RestClientException e1) {
                try {
                    o = restTemplate.postForObject("http://apm.harmonycloud.com:9900/SysUser/Syslogin", kevinMap, Object.class);
                } catch (RestClientException e2) {
                    try {
                        o = restTemplate.postForObject("http://apm.harmonycloud.com:9900/SysUser/Syslogin", kevinMap, Object.class);
                    } catch (RestClientException e3) {
                        o = restTemplate.postForObject("http://apm.harmonycloud.com:9900/SysUser/Syslogin", kevinMap, Object.class);
                    }
                }
            }
        }
        System.out.println(o);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<net.sf.json.JSONObject> requestEntity = new HttpEntity<>(net.sf.json.JSONObject.fromObject(kevinMap), headers);
        ResponseEntity<JSONObject> responseEntity =
                new RestTemplate().exchange("http://apm.harmonycloud.com:9900/SysUser/Syslogin", HttpMethod.POST, requestEntity, JSONObject.class);
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        String cookie = httpHeaders.get("Set-Cookie").toString();
        System.out.println(cookie);

    }
}
