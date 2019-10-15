 # 1、license文件授权
 # 2、绑定ip和mac
 # 3、限制使用日期，并能防止客户自己修改时间
 # 4、限制范围：禁止登录系统，数据加密防止登录数据库查询，完全删除代码和数据
 # 5、替换license文件即可延期
 host文件中添加  127.0.0.1 auth-server
  curl -i -H "Content-type:application/json" -X POST -d '{"orgCode":"TEST","remainDay":365,"expireDate":"20201008","ip":"172.16.3.196","mac":"B0-83-FE-70-3F-1F","authTime":"20190927162700","licenceKey":"sasdadada","data":"vYybJCklaKtUdTnBmmZFaaS9AfrEfPAXZJYGJ0CcAqdXg123X3NV1gdYlKRERjttc3qMoqrrr9pkEzTBcyC/4ar6fpQ0d3vHtbOjDIXUWDBhkpyYzBjnSN6tSDvazEjGy71KPBngfcNyAvdvmppXYV1MGHS/w1wBWgTomIK7l2c3MGjwW4azObM88vnKyBAjUfqf0Q6GeF+WOPXeSj8vcFPqHxCsVyKs"}' http://localhost:8080/auth