package com.antonybasan.jokehub.jokehub.services.util;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class HttpUtilsServiceImpl implements HttpUtilsService {

    @Override
    public <T> T sendRequest(String url, Class<T> type) {
        RestTemplate r = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        HttpEntity<T> response = r.exchange(url, HttpMethod.GET, entity, type);

        return response.getBody();
    }
}
