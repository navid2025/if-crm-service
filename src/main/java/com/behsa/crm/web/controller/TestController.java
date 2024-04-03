package com.behsa.crm.web.controller;

import com.behsa.crm.service.TestProcedureCall;
import com.behsa.crm.web.dto.TestRequest;
import com.behsa.crm.web.dto.TestResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestProcedureCall procedureCall;

    public TestController(TestProcedureCall procedureCall) {
        this.procedureCall = procedureCall;
    }

    @PostMapping
    public TestResponse postTest(@RequestBody TestRequest request){
        TestResponse response = new TestResponse();
        procedureCall.callTestProcedure(1,2);
        response.setResultCode("200");
        response.setResultDescription("Test response");
        return response;
    }
}
