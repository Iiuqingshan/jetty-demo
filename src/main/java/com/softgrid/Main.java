package com.softgrid;

import com.softgrid.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        //创建一个jetty 服务器 定义端口为8080
        Server server = new Server(8080);

        // 创建一个， 用于托管静态文件
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // 将 Servlet 注册到 Jetty 服务器 访问http://localhost:8080/hello
        context.addServlet(new ServletHolder(new HelloServlet()), "/hello");

        // 将 context 添加到服务器
        server.setHandler(context);
        // 启动服务器
        server.start();

        server.join();
    }
}