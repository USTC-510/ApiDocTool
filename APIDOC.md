# 目录
- [修改密码](#修改密码)
- [选课系统登录](#选课系统登录)
## 修改密码
### 请求URL
GET:  `http://localhost:8080/api/changePassword`
### 请求参数
|参数名|类型|
| :-: | :-: |
|无|无|
### 返回参数 
|参数名|类型|
| :-: | :-: |
|code|bool|
### 备注
这个api实现了密码的修改
## 选课系统登录
### 请求URL
POST:  `http://localhost:8080/api/login`
### 请求参数
|参数名|类型|
| :-: | :-: |
|username|string|
|password|string|
### 返回参数 
|参数名|类型|
| :-: | :-: |
|name|string|
|code|int|
### 备注
这个api实现了学生，老师和管理员的登录
