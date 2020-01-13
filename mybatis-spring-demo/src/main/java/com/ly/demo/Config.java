/**
 * Copyright 2010-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ly.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.ly.demo.mapper")
public class Config {

  @Bean
  public SqlSessionFactoryBean sqlSessionFactory(DataSource druidDataSource) throws Exception {
    PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(druidDataSource);
    factoryBean.setMapperLocations(resourcePatternResolver.getResources("mybatis/mapper/*.xml"));
    return factoryBean;
  }

  @Bean
  public DataSource druidDataSource() {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl("jdbc:mysql://127.0.0.1:3306/tmp_ly?serverTimezone=UTC");
    datasource.setUsername("root");
    datasource.setPassword("123456ly");
    datasource.setDriverClassName("com.mysql.jdbc.Driver");
    return datasource;
  }


}
