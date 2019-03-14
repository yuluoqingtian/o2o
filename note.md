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
 
 
### 3、mybatis复杂查询的方法，一对多，一对一，多对多，一对多再对多

    1. mapper中的resulttype可以自定义查询返回的类型，可以包括其他的类(表)，和其他类（表）的集合。
    2. resultMap 中 <result/> 标签中的 property 和 colum 可以将数据库表的列名映射到实体类的属性名上面
    3. resultMap的级联：**待完善**
    4. 若想在级联中的collection中映射，实体类需实现Serializable接口，并具有相应的getter，setter
    5. 联级查询中的同名问题
    
    
    
### 后台完成获取一次性验证码接口
    1. 解决Can't create output stream！
    在使用ImageIO进行图片写操作时，默认会使用缓存目录:${tomcat}/temp有些生产环境的tomcat，会将temp目录删除，因此报错
    目前可以使用的解决办法
        1. ImageIO默认是使用缓存目录，可以通过ImageIO.setUseCache(false)来设置，更改缓存策略，不使用文件目录缓存，使用内存缓存
        2. 通过ImageIO.setCacheDirectory(cacheDirectory);设置任意的、存在的缓存目录
    
    2. 参考网站
    工具类 [https://blog.csdn.net/doublezsx/article/details/79938035]
    controller层 [https://blog.csdn.net/qq_39544768/article/details/86625353]
                                               

    