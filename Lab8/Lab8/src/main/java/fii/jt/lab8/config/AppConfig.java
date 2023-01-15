package fii.jt.lab8.config;

import fii.jt.lab8.controller.DocsController;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("resources")
@ApplicationScoped
public class AppConfig extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(DocsController.class);
    }
    public final Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
