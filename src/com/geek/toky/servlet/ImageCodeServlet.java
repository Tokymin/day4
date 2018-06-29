package com.geek.toky.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

//这个类要解决图片验证码的问题
//注册功能有让用户输入图片中显示的内容的模块。
@WebServlet("ImageCodeServlet")
public class ImageCodeServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public ImageCodeServlet(){}
    private List<String> words=new ArrayList<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        String path=getServletContext().getRealPath("WEB-INF/new_words.txt");
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
            String line;
            for(;(line=reader.readLine())!=null;){
                words.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        //Java要创建一个图片
        //Java AWT组件  用于窗体绘制等等的工具类。
        //也就是Java可以描述一个图片
        //世界上的图片我们理解为一个一个的像素点。
        //每一个像素点都有自己的颜色，组成了一个图片。
        //每一个像素点都有（透明度、红色、绿色、蓝色）四个部分。
        //#ff00ff
        //为什么用rgb三个颜色呢？
        //因为三原色。

        //Java int类型是四个字节。
        //很巧，颜色有四个部分。
        //我们用int类型的四个字节来描述颜色的四个部分
        //高八位：透明度
        //次高八位：红色
        //次低八位：绿色
        //低八位：蓝色

        //1111 1111
        //1111 1111
        //0000 0000
        //0000 0000

        //生成一个验证码
        //先确定要生成的验证码的内容的字符串，也就是一个成语
        //随机
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
