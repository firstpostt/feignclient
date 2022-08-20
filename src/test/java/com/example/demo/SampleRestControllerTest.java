package com.example.demo;

import com.example.demo.client.RestTemplateConfiguration;
import com.example.demo.client.SampleFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

@SpringJUnitConfig(classes = {SampleFeignClient.class, RestTemplateConfiguration.class})
@SpringBootTest(properties = "feign.url=http://localhost:${wiremock.server.port}/test/success")
@AutoConfigureWireMock(port = 0)
class SampleRestControllerTest {
    @Autowired
    private SampleFeignClient sampleFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void test() {
        System.out.println("I could autowire restTemplate but not sampleFeignClient.");
        var sampleRestController = new SampleRestController(request -> null);
        var result = sampleRestController.test();
        System.out.println(result);
    }
}
