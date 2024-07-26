package utils;

import annotations.Api;
import annotations.Request;
import annotations.Response;
import annotations.Url;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
/**
 * @Author:   周康睿
 * @Description:  核心  有多个重载方法createDoc
 * @Version:   1.0
 */
@SuppressWarnings("all")
public class ApiDocFactory
{
    public static void createDocPerMethod(Method meth) throws Exception
    {
        Class<?> cla = ApiDoc.class;
        ApiDoc apiDoc = (ApiDoc)cla.newInstance();

        Method setDescription = cla.getMethod("setDescription",String.class);
        Method setUrl = cla.getMethod("setUrl",String.class);
        Method setMethod = cla.getMethod("setMethod",String.class);
        Method setParamName_reqeust = cla.getMethod("setParamName_request",ArrayList.class);
        Method setParamType_request = cla.getMethod("setParamType_request", ArrayList.class);
        Method setParamName_response = cla.getMethod("setParamName_response", ArrayList.class);
        Method setParamType_response = cla.getMethod("setParamType_response", ArrayList.class);

        Api api = meth.getAnnotation(Api.class);
        Request request = meth.getAnnotation(Request.class);
        Response response = meth.getAnnotation(Response.class);
        Url url = meth.getAnnotation(Url.class);

        boolean flag = false;

        if (api != null)
        {
            setDescription.invoke(apiDoc,api.value());
            flag = true;
        }
        if (request != null)
        {
            ArrayList<String> requestNameList = new ArrayList<>(Arrays.asList(request.name()));
            ArrayList<String> requestTypeList = new ArrayList<>(Arrays.asList(request.type()));

            setParamName_reqeust.invoke(apiDoc,requestNameList);
            setParamType_request.invoke(apiDoc,requestTypeList);
            flag = true;
        }
        if (response != null)
        {
            ArrayList<String> responseNameList = new ArrayList<>(Arrays.asList(response.name()));
            ArrayList<String> responseTypeList = new ArrayList<>(Arrays.asList(response.type()));

            setParamName_response.invoke(apiDoc,responseNameList);
            setParamType_response.invoke(apiDoc,responseTypeList);
            flag = true;
        }
        if (url != null)
        {
            setMethod.invoke(apiDoc,url.method());
            setUrl.invoke(apiDoc,url.url());
            flag = true;
        }

        if (!exists(apiDoc) && flag) {apiDoc.createDoc();}
    }

    public static void createDoc(ArrayList<Class> classes) throws Exception
    {
        for (Class cla : classes)
        {
            Method[] methods = cla.getMethods();
            for (Method method : methods)
            {
                createDocPerMethod(method);
            }
        }
    }

    public static void createDoc(Class[] classes) throws Exception
    {
        for (Class cla : classes)
        {
            Method[] methods = cla.getMethods();
            for (Method method : methods)
            {
                createDocPerMethod(method);
            }
        }
    }

    public static void createDoc(List<Class> classes) throws Exception
    {
        for (Class cla : classes)
        {
            Method[] methods = cla.getMethods();
            for (Method method : methods)
            {
                createDocPerMethod(method);
            }
        }
    }

    public static void createDoc(Set<Class> classes) throws Exception
    {
        for (Class cla : classes)
        {
            Method[] methods = cla.getMethods();
            for (Method method : methods)
            {
                createDocPerMethod(method);
            }
        }
    }

    public static boolean exists(ApiDoc apiDoc) throws IOException
    {
        String filePath = "APIDOC.md";
        String searchText = apiDoc.getUrl();

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {Files.createFile(path);}
        try {
            return Files.lines(path)
                    .anyMatch(line -> line.contains(searchText));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }


    }
}
