import annotations.*;
import utils.ApiDoc;
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
    public ArrayList<Object> api(String username, String password)
    {
        String name = "zkr";
        int code = 200;
        ArrayList<Object> res = new ArrayList<Object>();
        res.add(name);
        res.add(code);
        return res;
    }

    public static void main() throws Exception
    {
        Class[] classes = new Class[]{Test.class};
        ApiDocFactory.createDoc(classes);
    }

}
