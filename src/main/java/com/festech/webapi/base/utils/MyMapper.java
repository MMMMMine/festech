package com.festech.webapi.base.utils;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by frank on 2018/3/9.
 */
public interface MyMapper<T> extends BaseMapper<T>, MySqlMapper<T>,ExampleMapper<T> {
}
