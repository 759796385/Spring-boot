package com.newtonk.MyBaitsMapper;

import com.newtonk.MyBaitsMapper.provider.DeleteAllMapperImpl;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

/**
 * Created by newtonk on 2016/6/6.
 */
public interface DeleteAllMapper<T> {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = DeleteAllMapperImpl.class, method = "dynamicSQL")
    public int deleteAll();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = DeleteAllMapperImpl.class, method = "dynamicSQL")
    public int setIncrementRestart();
}
