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

