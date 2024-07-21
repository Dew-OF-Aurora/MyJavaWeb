package com.aurora.boot02jdbc;

import com.aurora.boot02jdbc.pojo.ResultData;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.aurora.tools.CommonUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@SpringBootApplication
public class Boot02JdbcApplication implements ApplicationRunner {

    private final JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Boot02JdbcApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("testSP")
                .declareParameters(
                        new SqlParameter("input", Types.VARCHAR),
                        new SqlOutParameter("output", Types.VARCHAR)
                ).returningResultSet("customers", (rs, rowNum) -> {
                    // be used by new RowMapper<Object>()
                    // How to deal with unknown type
                    return new ResultData(rs.getInt("CustomerID"), rs.getString("CustomerName"));
                });
        try {
            Map<String, Object> resultData = simpleJdbcCall.execute(new MapSqlParameterSource()
                    .addValue("input", "4")
            );
            System.out.println(resultData);
            List<ResultData> customers = CommonUtil.getObject("customers", resultData, new TypeReference<>() {
            });
            System.out.println(customers);
        } catch (Exception e) {
            if (e.getCause() instanceof SQLException sqlEx) {
                System.err.println("SQL Error Code: " + sqlEx.getErrorCode());
                System.err.println("SQL State: " + sqlEx.getSQLState());
                System.err.println("Error Message: " + sqlEx.getMessage());
            } else {
                e.printStackTrace();
            }
        }

        // simple execute
        SimpleJdbcCall tempSp = new SimpleJdbcCall(jdbcTemplate).withProcedureName("testSP");
        Map<String, Object> execute = tempSp.execute(Map.of("input", "4", "output", ""));
        System.out.println(execute);
    }
}
