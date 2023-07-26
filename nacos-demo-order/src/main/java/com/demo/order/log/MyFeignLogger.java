package com.demo.order.log;

import feign.Request;
import feign.Response;
import feign.Util;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static feign.Util.*;


public class MyFeignLogger extends feign.Logger {
    private final org.slf4j.Logger log = LoggerFactory.getLogger("FeignLogger");

    private String headers(Map<String, Collection<String>> headerMap) {
        StringBuilder headers = new StringBuilder();
        for (String field : headerMap.keySet()) {
            for (String value : valuesOrEmpty(headerMap, field)) {
                headers.append("\n").append(field).append(": ").append(value);
            }
        }
        return headers.toString();
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        String url = request.url();
        String body = "";
        if (request.body() != null) {
            body = new String(request.body());
        }
        log.info("Sending {} request {}\nbody: {}\nheader: {}"
                , request.httpMethod(), url, body, headers(request.headers()));
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response,
                                              long elapsedTime) throws IOException {
        int status = response.status();
        String url = response.request().url();
        String content = "";
        if (response.body() != null && !(status == 204 || status == 205)) {
            byte[] bodyData = Util.toByteArray(response.body().asInputStream());
            if (bodyData.length > 0) {
                content = decodeOrDefault(bodyData, UTF_8, "Binary data");
            }
            response = response.toBuilder().body(bodyData).build();
        }
        log.info("Received response code: {} {}ms for {} \nbody: {}", status, elapsedTime, url, content);
        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
    }
}
