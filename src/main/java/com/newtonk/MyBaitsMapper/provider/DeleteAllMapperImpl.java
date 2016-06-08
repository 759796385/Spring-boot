package com.newtonk.MyBaitsMapper.provider;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

/**
 * Created by newtonk on 2016/6/6.
 */
public class DeleteAllMapperImpl extends MapperTemplate {
    public DeleteAllMapperImpl(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String deleteAll(MappedStatement ms) {
        Class entityClass = this.getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append("TRUNCATE TABLE ");
        sql.append(this.tableName(entityClass));
        return sql.toString();
    }

    public String setIncrementRestart(MappedStatement ms){
        Class entityClass = this.getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append("alter table ");
        sql.append(this.tableName(entityClass));
        sql.append(" AUTO_INCREMENT=1");
        return sql.toString();
    }
}
