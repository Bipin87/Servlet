package com.Capgemini.tomcat_servlet.create_a_simple_java_web_server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleWebServer {
    public static void main(String[] args) throws IOException {
        int port = 8080; // Define the port
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // Define a context (URL path) and handler
        server.createContext("/", new MyHandler());
        
        // Start the server
        server.setExecutor(null);
        server.start();
        
        System.out.println("Server started on port " + port);
    }

    // Handler to process HTTP requests
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello World";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
