package com.latewind.bootstart.runner;

import com.latewind.bootstart.config.ThreadPools;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.util.ReferenceBundle;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class StopRunner implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {


        ThreadPools.shutdown();
        ClassInfo.getAllClassInfo().forEach(classInfo -> {
            ClassInfo.remove(classInfo.getTheClass());
        });


        final Set<String> providersToRemove = new HashSet<String>();
        for (java.security.Provider provider : java.security.Security.getProviders()) {
            if (provider.getClass().getClassLoader() == StopRunner.class.getClassLoader()) {
                providersToRemove.add(provider.getName());
            }
        }
        if (!providersToRemove.isEmpty()) {
            for (String providerName : providersToRemove) {
                java.security.Security.removeProvider(providerName);
            }
        }


    }
}
