[TOC]

# SpringBoot项目

### Desc
基于SpringBoot搭建，包含平时开发过程中一些常用工具的封装

### 目录说明
- [annotation](src/main/java/com/homon/SpringBoot/annotation)注解
    - [DB](src/main/java/com/homon/SpringBoot/annotation/DB.java)用来在多数据源场景下用来切换数据源，后续会增加主从切换（配合事务）使用时需要手动或者增加自动注入注解
    `@Import({DynamicDataSourceRegister.class})`
    - [Log](src/main/java/com/homon/SpringBoot/annotation/Log.java)Add in controller method will print log include input and output 
- [aop](src/main/java/com/homon/SpringBoot/aop)切面
- [bean](src/main/java/com/homon/SpringBoot/bean)实体类
- [controller](src/main/java/com/homon/SpringBoot/controller)接口层、是很薄的一层，最好不要有业务逻辑
- [dao](src/main/java/com/homon/SpringBoot/dao)持久层、主要和数据库交互
- [service](src/main/java/com/homon/SpringBoot/service)
- [test](src/main/java/com/homon/SpringBoot/test)小玩意
- [util](src/main/java/com/homon/SpringBoot/util)工具类

### Feture