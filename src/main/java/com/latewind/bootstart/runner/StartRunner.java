package com.latewind.bootstart.runner;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        GroovyClassLoader classLoader = new GroovyClassLoader();

        Class groovyClass = classLoader.parseClass(" 1 + 1");
        groovyClass.newInstance();

    }
}
