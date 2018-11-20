package com.harlandclarke.bootdemo.startup;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;


@Component
public class Start implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Value("${A_CELL_PORT}")
    private int A_CELL_PORT;

    @Value("${B_CELL_PORT}")
    private int B_CELL_PORT;

    private static final Logger logger = LoggerFactory.getLogger(Start.class);

    @PostConstruct
    public void init() {
        System.out.println("-------------------> Initializing Services");
        System.out.println(Start.class.getClassLoader().getResource("logging.properties"));
        System.out.println(System.getProperty("java.io.tmpdir"));

    }

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        int defaultport = 8900;

        String currentDirectory = System.getProperty("user.dir");
        // currentDirectory = currentDirectory.substring(currentDirectory.length() - 6); //SLINGDOC_A or SLINGDOC_B
        System.out.println("Current working directory : " + currentDirectory);
        if (currentDirectory.equals("A_CELL")) {
            defaultport = A_CELL_PORT;
        }
        if (currentDirectory.equals("B_CELL")) {
            defaultport = B_CELL_PORT;
        }
        //logger.info("Setting Container Port : "+defaultport);
        System.out.println("Setting Caintainer Port : " + defaultport);


        factory.setContextPath("");
        factory.setPort(defaultport);
    }
}