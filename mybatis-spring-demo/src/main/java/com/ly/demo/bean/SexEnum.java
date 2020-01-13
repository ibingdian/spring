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
package com.ly.demo.bean;

/**
 * 处理枚举类型
 *
 * 1、存储枚举的名称
 * mybatis对枚举类型的默认处理方式，使用的类型处理器是org.apache.ibatis.type.EnumTypeHandler
 * insert into person (name,sex) values ('ls','nan');
 *
 * 2、存储枚举的索引
 * 使用的类型处理器是org.apache.ibatis.type.EnumOrdinalTypeHandler
 * insert into person (name,sex) values ('ls',0);
 *
 * 3、存储枚举的值
 * 如果想存储上面枚举的值，比如：SexEnum.nan的值sex1,就需要创建一个自定义的类型处理器,只需要继承BaseTypeHandler
 * insert into person (name,sex) values ('ls','男')：
 *
 *
 */
public enum SexEnum {
  //男
  nan("男"),
  //女
  nv("女");

  private String sex;
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }

  SexEnum(String s){
    this.sex=s;
  }
}
