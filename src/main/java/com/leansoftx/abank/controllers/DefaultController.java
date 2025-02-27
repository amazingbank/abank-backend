package com.leansoftx.abank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @Autowired
    private org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext serverContext;

    @GetMapping("/")
    public ServerInfo serverInfo() {
        int port = serverContext.getWebServer().getPort();
        return new ServerInfo(port, "0.0.1");
    }

    private static class ServerInfo {
        private final String message;
        private final String version;

        public ServerInfo(int port, String version) {
            this.message = "Abank Backend Server is running at port " + port;
            this.version = version;
        }

        public String getMessage() {
            return message;
        }

        public String getVersion() {
            return version;
        }
    }
}
