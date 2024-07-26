import annotations.Api;
import annotations.Request;
import annotations.Response;
import annotations.Url;
import utils.ApiDocFactory;
import java.util.ArrayList;


public class Test
{
    //下面定义了一个接口
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

    public static void main() throws Exception
    {
        Class[] classes = new Class[]{Test.class};
        ApiDocFactory.createDoc(classes);
    }

}
