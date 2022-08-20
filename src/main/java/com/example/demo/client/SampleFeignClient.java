package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "sampleClient",
        url = "${feign.url}"
)
public interface SampleFeignClient {
    @PostMapping
    ResponseEntity<String> test(@RequestBody MultiValueMap<String, String> request);
}
