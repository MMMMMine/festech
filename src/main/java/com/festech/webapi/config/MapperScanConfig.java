package com.festech.webapi.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "com.festech.webapi.mapper")
public class MapperScanConfig {
}
