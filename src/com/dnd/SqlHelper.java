package com.dnd;


import com.mysql.cj.protocol.Resultset;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SqlHelper extends DBConnectionHelper {
    private static final Logger logger = LogManager.getLogger(SqlHelper.class);

    Integer appId;

    public SqlHelper(Integer appId) {
        this.appId = appId;
    }

    public SqlHelper() {
    }

    protected class MrpcStatementCreator implements CallableStatementCreator {
        private String mrpcId;
        private String sql;
        private Object[] parameters;

        public MrpcStatementCreator(String mrpcId, String sql, Object... parameters) {
            this.mrpcId = mrpcId;
            this.sql = sql;
            this.parameters = parameters;
        }

        @Override
        public CallableStatement createCallableStatement(Connection connection) throws SQLException {
            CallableStatement cs = connection.prepareCall(sql);
            // Set the first parameter to the mrpcId
            cs.setString(1, mrpcId);
            // Tell the JDBC driver to that the response from the MRPC is a string and to set it to the second parameter
            cs.registerOutParameter(2, Types.VARCHAR);
            // Set the remainder of the parameters
            for (int i = 0; i < parameters.length; i++) {
                String value = parameters[i] == null ? null : parameters[i].toString();
                cs.setString(i + 3, value);
            }
            return cs;
        }
    }

    protected class MrpcStatementCallback<T> implements CallableStatementCallback<T> {
        private Function<String, T> outputTransformer;

        public MrpcStatementCallback(Function<String, T> outputTransformer) {
            this.outputTransformer = outputTransformer;
        }

        @Override
        public T doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
            cs.executeQuery();
            String jsonResponse = cs.getString(2);
            logger.debug("JSON Response: " + jsonResponse);
            return outputTransformer.apply(jsonResponse);
        }
    }
}
