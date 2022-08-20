package com.example.demo;

import com.example.demo.client.SampleFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleRestController {

    private final SampleFeignClient sampleFeignClient;

    @GetMapping(value="/test")
    public String test() {
        var multiValueMap = new LinkedMultiValueMap<String, String>();
        multiValueMap.add("test", "testvalue");
        var test = sampleFeignClient.test(multiValueMap);
        return test != null ? test.getBody() : null;
    }
}
