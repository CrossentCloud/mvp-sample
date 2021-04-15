package com.crossent.example.frontend.service;

import com.crossent.example.frontend.model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class FrontendRecordService {

    private static final Logger logger = LoggerFactory.getLogger(FrontendRecordService.class);

    @Value("${istio.backend.svc:}")
    private String backendApi;

    @Autowired
    private RestTemplate restTemplate;

    public void insertData(Record record) {

        URI uri = setURI(String.format("%s%s%s", "http://", backendApi, "/api/record/insert"), new LinkedMultiValueMap<>());
        logger.info(uri.toString());
        HttpEntity<Record> request = new HttpEntity<>(record, setBasicHeaders());
        restTemplate.postForEntity(uri, request, Object.class);
    }

    public List<Record> selectData() {

        HttpEntity<String> request = new HttpEntity<>(setBasicHeaders());
        URI uri = setURI(String.format("%s%s%s", "http://", backendApi, "/api/record/list"), new LinkedMultiValueMap<>());
        logger.info(uri.toString());
        ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.GET, request, Object.class);
        return (List<Record>) result.getBody();
    }


    private HttpHeaders setBasicHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    private URI setURI(String uri, MultiValueMap<String, String> maps) {
        return UriComponentsBuilder.fromHttpUrl(uri).queryParams(maps).build().encode().toUri();
    }
}
