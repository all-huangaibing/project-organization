# es-demo
#es swagger-ui 
为什么@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
Spring Boot会自动根据jar包的依赖来自动配置项目，例如当你项目下面有HSQLDB的依赖，Spring Boot会自动创建默认的内存数据库的数据源DataSource，
但我们使用Mybatis自定义配置，想自己创建DataSource时就必须注释掉DataSourceAutoConfiguration。

