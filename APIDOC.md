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
