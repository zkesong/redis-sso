# redis-sso
单点登录redis简化版实现

### 使用方式

配置application.yml相关文件，包括redis、服务端口port、用户登录数据库连接信息等

### 数据库需要提供用户表，名为t_user,参考如下建表语句：
```Bash
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usrname` varchar(255) NOT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8
```
### 相关api接口

1./sso/userInfo,查看用户登录信息，data为null表示未登录

2./sso/doLogin，post方法访问，实现登录操作，提交用户名密码

3./sso/doLogout，退出登录

4./sso/login?service=aaa,调转登录页面，需提供service服务名参数

5./sso/health,查看单点登录服务是否正常运行
