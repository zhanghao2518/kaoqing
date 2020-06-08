# spring_demo

#### 介绍
spring boot + rest + data jdbc + mysql

#### 软件架构
纯后端，向前提供RESTful接口。持久化层使用 MySQL


#### 安装教程

1.  需要安装 jdk 1.8+ 和 maven
2.  需要安装mysql，在其中建立数据库名为demo的数据库，建立表apply、user、record具体内容可参考entity中的apply、user、record
3.  修改 src/main/resource/application.properties 中关于数据库连接的设置

#### 使用说明

1.  在项目目录下运行 mvn spring-boot:run
2.  在浏览器中运行 http://localhost:8080/login?name=(数据库存储项)&password=(数据库存储项)
3.  使用 PostMan 或类似软件，执行 GET、POST、PUT、DELETE 等操作。

