import annotations.*;
import utils.ApiDocFactory;
import java.util.ArrayList;

/**
 * @Author:   周康睿
 * @Description:  测试代码
 * @Version:   1.0
 */
public class Test
{
    //下面定义了一个接口
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
