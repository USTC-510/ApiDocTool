# ApiDocTool
 这个工具能够快速构建一个api文档
 ===============================
 导入方法：
 ------------
 把src/java/目录下的annotations包和utils包移入你的项目中。  
 
 注意：你的项目需要引入lombok的依赖：  
 ```
      <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.32</version>
            <scope>provided</scope>
      </dependency>
 ```
 
 使用方法：
 ------------------
 主要是下面4个注解,它们都需要写在方法上面。

   
 **@Api**: 携带一个String类型参数，代表api的名称/作用，它将会显示在文档的最上方。  
 
 **@Url**: 携带两个String类型参数，method和url，代表请求方法（POST,GET等）以及接口的URL。  
 
 **@Request**：携带两个String[]类型参数，name和type，代表请求体中携带的参数名称和类型。  
 
 **@Response**：携带两个String[]类型参数，name和type，代表响应体中携带的参数名称和类型。  
 

 最后，在整个项目的main方法中，加入下面两行代码:  
 
  ` Class[] classes = new Class[]{...}; `
  
  ` ApiDocFactory.createDoc(classes); `  
  
  其中，...表示项目中所有添加了注解的方法所属类的.class文件。例如，如果Test类中有方法上写了注解，那么...处应填写 Test.class。  
  运行后，你的项目根目录下会自动创建一个APIDOC.md文件，即为Api文档。

  示例代码：
  --------------------
  ```
  public class Test
{
    //下面定义了一个接口（接口格式并不正确，省略了@RequestMapping等等，仅作为一个示例）
    @Api("选课系统登录")
    @Url(method = "POST", url = "http://localhost:8080/api/login")
    @Request(name = {"username","password"}, type = {"string","string"})
    @Response(name = {"name","code"}, type = {"string","int"})
    public ArrayList<Object> api(String username, String password)
    {
        String name = "zkr";
        int code = 200;
        ArrayList<Object> res = new ArrayList<Object>();
        res.add(name);
        res.add(code);
        return res;
    }
  
    //下面是main方法，当然实际项目中一般不会与接口写在同一个类中
    public static void main() throws Exception
    {
        Class[] classes = new Class[]{Test.class};
        ApiDocFactory.createDoc(classes);
    }

}
  ```
运行效果：
----------

[API]  ## 选课系统登录
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

  
 

 
