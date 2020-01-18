package com.study.generator.type;

import com.study.generator.model.Enabled;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnabledTypeHandler implements TypeHandler<Enabled> {
    private final Map<Integer, Enabled> enabledMap = new HashMap<>();

    public EnabledTypeHandler() {
        for (Enabled value : Enabled.values()) {
            enabledMap.put(value.getValue(), value);
        }
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getValue());
    }

    @Override
    public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        return enabledMap.get(i);
    }

    @Override
    public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        return enabledMap.get(i);
    }

    @Override
    public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        return enabledMap.get(i);
    }
}
