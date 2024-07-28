package utils;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author:   周康睿
 * @Description:  这个类不是为开发者准备的
 * @Version:   1.0
 */

@SuppressWarnings("all")
public class ApiDoc
{
    public static File file = new File("APIDOC.md");
    private String description = "还没有描述哦...";
    private String url = "还没有url哦...";
    private String method = "还没有请求方法哦...";
    private ArrayList<String> paramName_request = new ArrayList<String>();
    private ArrayList<String> paramType_request = new ArrayList<String>();
    private ArrayList<String> paramName_response = new ArrayList<String>();
    private ArrayList<String> paramType_response = new ArrayList<String>();
    private String tip = null;

    public ApiDoc(String description, String url, String method, ArrayList<String> paramName_request, ArrayList<String> paramType_request, ArrayList<String> paramName_response, ArrayList<String> paramType_response, String tip) {
        this.description = description;
        this.url = url;
        this.method = method;
        this.paramName_request = paramName_request;
        this.paramType_request = paramType_request;
        this.paramName_response = paramName_response;
        this.paramType_response = paramType_response;
        this.tip = tip;
    }

    public ApiDoc(){

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ArrayList<String> getParamName_request() {
        return paramName_request;
    }

    public void setParamName_request(ArrayList<String> paramName_request) {
        this.paramName_request = new ArrayList<>(paramName_request);
    }

    public ArrayList<String> getParamType_request() {
        return paramType_request;
    }

    public void setParamType_request(ArrayList<String> paramType_request) {
        this.paramType_request = new ArrayList<>(paramType_request);
    }

    public ArrayList<String> getParamName_response() {
        return paramName_response;
    }

    public void setParamName_response(ArrayList<String> paramName_response) {
        this.paramName_response = new ArrayList<>(paramName_response);
    }

    public ArrayList<String> getParamType_response() {
        return paramType_response;
    }

    public void setParamType_response(ArrayList<String> paramType_response) {
        this.paramType_response = new ArrayList<>(paramType_response);
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void createDoc() throws Exception
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
            writer.println("## "+description);
            writer.println("### 请求URL");
            writer.println(method + ":  "+"`"+ url + "`");
            writer.println("### 请求参数");
            writer.println("|参数名|类型|");
            writer.println("| :-: | :-: |");
            for (int i = 0;i < paramName_request.size();i++)
            {
                writer.println("|"+paramName_request.get(i) +"|"+paramType_request.get(i)+"|");
            }
            writer.println("### 返回参数 ");
            writer.println("|参数名|类型|");
            writer.println("| :-: | :-: |");
            for (int i = 0;i < paramName_response.size();i++)
            {
                writer.println("|"+paramName_response.get(i)+"|"+paramType_response.get(i)+"|");
            }
            if (tip != null)
            {
                writer.println("### 备注");
                writer.println(tip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
