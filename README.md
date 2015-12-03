# spring-authorization-manager-demo
https://github.com/ScienJus/spring-authorization-manager 的Demo

使用方法：

需要首先下载`spring-authorization-manager`，将这个jar添加到你的maven私服或本地仓库。

下载该项目，并运行。

###演示正常情况

输入用户名，点击登录，获取 Token。

输入 Token，点击查看登录用户名，会显示刚才输入的用户名。

输入 Token，点击退出登录，会显示退出登录成功。

输入 Token，点击查看登录用户名，会显示未登录。

输入 Token，点击退出登录，会显示未登录。

###演示多用户登录同一账号

输入用户名，点击登录，获取 Token1。

输入同一用户名，点击登录，获取 Token2。

输入 Token2，点击查看登录用户名，会显示刚才输入的用户名。

输入 Token1，点击查看登录用户名，会显示未登录。
