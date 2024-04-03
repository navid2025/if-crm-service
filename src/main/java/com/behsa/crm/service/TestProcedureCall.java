package com.behsa.crm.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Service
public class TestProcedureCall {

    private final JdbcTemplate jdbcTemplate;


    public TestProcedureCall(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> callTestProcedure(Integer input1, Integer input2) {
        SimpleJdbcCall procedureCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("test_procedure")
                .declareParameters(
                        new SqlParameter("input1", Types.INTEGER),
                        new SqlParameter("input2", Types.INTEGER));
        Map<String, Object> out = procedureCall.execute(input1,input2);
        Integer output1 = (Integer) out.get("output1");
        Integer output2 = (Integer) out.get("output2");
        System.out.println(output1 + "  1");
        System.out.println(output2 + "  2");
        return List.of(output1, output2);
    }
}
