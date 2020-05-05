### 一个简单的springboot脚手架

#### 2020.05.05
1. 新增
>   1. RabbitMQ的整合
>   2. Redis的整合

#### 2020.04.11
1. 新增：
>   1. mybatis-plus配置，及代码；
>   2. Junit+Mockito单元测试
2. 注意点：
>   1. mybatis-plus自增的id会非常大，所以需要在实体类里加上注解 @TableId(value = "id",type = IdType.AUTO)
。这里type = IdType.AUTO属性加上后，将不会使用mybatis-plus的自增而是使用数据库给的自增值，就不会出现ID过大的
问题了。
>   2. 使用@Slf4j注解后，仍然无法使用log.info()这些来打日志，是因为使用的IDEA没添加lombok的插件导致的，添加下
插件即可。

#### 简介
除了一个hello world一无所有

使用时可以根据需要编写resource下的Dockerfile来制作docker镜像



