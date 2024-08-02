 # ApiDocTool
 *这个轻量级的工具能够快速构建一个api文档*
 ==============================
 优势：
 -------------
 &emsp;&emsp;**1. 以*注解形式*在代码中即时声明api文档的内容，当注解参数改变时，api文档的内容也会随之改变。**  
 &emsp;&emsp;**2. api文档的格式简明扼要，易于阅读。**  
 &emsp;&emsp;**3. api文档自动添加了目录，便于查找。**  
 &emsp;&emsp;**4. 工具的嵌入性强，不需要额外引入任何依赖，不会对原有项目的运行造成任何影响。**
 
 导入方法：
 ------------
  &emsp;&emsp;把src/java/目录下的annotations包和utils包移入你的项目中。  
 
 使用方法：
 ------------------
 &emsp;&emsp;主要是下面5个注解,它们都需要写在方法（也就是api）上面。**注意**，这些注解中，只有@Api是在文档中生成内容而必须要写的，如果不写@Api就不会在文档中生成对应的api信息。  
 
  &emsp;&emsp;**@Api**: 携带一个String类型参数，代表api的名称，它将会显示在api文档的最上方，并且会显示在目录中。**如果要为api创建文档并且收录在目录中，这个注解是必需的。**  
 
  &emsp;&emsp;**@Url**: 携带两个String类型参数，method和url，代表请求方法（POST,GET等）以及接口的URL。  
 
  &emsp;&emsp;**@Request**：携带两个String[]类型参数，name和type，代表请求体中携带的参数名称和类型。  
 
  &emsp;&emsp;**@Response**：携带两个String[]类型参数，name和type，代表响应体中携带的参数名称和类型。  

  &emsp;&emsp;**@Remark**: 携带一个String类型参数，代表api的备注，它将会显示在api文档的最下方。  

  &emsp;&emsp;**Tips:** 如果请求体中没有参数，那么@Request中不用填写参数，直接写@Request。@Response同理。（当然你也可以写 @Request(name="无",type="无"),与直接写@Request的效果一样 )。除了这两个注解之外，其它3个注解只要使用了就必须填写参数。
 

  &emsp;&emsp;最后，在整个项目的main方法中，加入下面两行代码:  
 
  ```java
Class[] classes = new Class[]{...};
ApiDocFactory.createDoc(classes); 
  ``` 
  
   &emsp;&emsp;其中，...表示项目中所有添加了注解的方法所属类的.class文件。例如，如果Test类中有方法(api)上写了注解，那么...处应填写 Test.class(也就是在类名后面加上.class)。  
   &emsp;&emsp;**运行后，你的项目根目录下会自动创建一个APIDOC.md文件，即为Api文档。**  
  
  示例代码：
  --------------------
  ```java
public class Test
{
    //下面定义了两个api
    @Api("选课系统登录")
    @Url(method = "POST", url = "http://localhost:8080/api/login")
    @Request(name = {"username","password"}, type = {"string","string"})
    @Response(name = {"name","code"}, type = {"string","int"})
    @Remark("这个api实现了学生，老师和管理员的登录")
    public void api1(String username, String password)
    {
        //这是第一个api
    }

    @Api("修改密码")
    @Url(method = "GET", url = "http://localhost:8080/api/changePassword")
    @Request
    @Response(name = {"code"}, type = {"bool"})
    @Remark("这个api实现了密码的修改")
    public void api2()
    {
        //这是第二个api
    }

    public static void main() throws Exception
    {
        Class[] classes = new Class[]{Test.class};
        ApiDocFactory.createDoc(classes);
    }

}
  ```
运行效果：
----------

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



  
 

 
