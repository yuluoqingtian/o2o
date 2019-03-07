## 2019-02-11
#### 1、IDEA如何更改Dynamic Web Module即web.xml的版本
参考连接   http://www.codingwhy.com/view/976.html

按照链接中教程设置过后，新建web.xml文件，并添加如下模板内容

```xml
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         id="WebApp_ID" version="3.1">
    <display-name>Archetype Created Web Application</display-name>
</web-app>

```

<br>

#### 2、mysql指定字符编码格式为utf-8

##### 数据库级
```sql
CREATE DATABASE db_name DEFAULT CHARACTER SET utf8;
```
##### 表级
```sql
CREATE TABLE  `db_name`.`tb_name` (id VARCHAR(20) NOT NULL,name VARCHAR(20) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```


## 2019-02-14
#### 1、配置好spring相关的xml文件之后，启动tomcat服务器，报错**通配符的匹配很全面, 但无法找到元素 'tx:annotation-driven'**或者** 通配符的匹配很全面, 但无法找到元素 'mvc:annotation-driven' 的声明**
原因大部分可能是文件头部的命名空间发生错误，这里备份下能够正常运行的头部写法

spring-dao.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">
       
</beans>
```

spring-service.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/tx
         http://www.springframework.org/schema/tx/spring-tx.xsd
         http://www.springframework.org/schema/context
         http://www.springframework.org/schema/context/spring-context.xsd">
         
</beans>
```

spring-web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/mvc
           http://www.springframework.org/schema/mvc/spring-mvc.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
           
</beans>
```

#### 2、Logback日志配置
- logback的主要标签
    - logger：主要用于存放日志对象，定义日志的类型、级别
    - appender：主要用于指定日志输出的目的地，可以是控制台，文件等
    - layout：用来格式化日志输出
    