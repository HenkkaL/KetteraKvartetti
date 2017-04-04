/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp;

import gherkin.Main;
import static org.codehaus.groovy.ast.tools.GeneralUtils.args;
import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author mlyra
 */
public class ServerRule extends ExternalResource{
    
    private final int port;
    ConfigurableApplicationContext app;
    
    public ServerRule(int port) {
        this.port = port;
    }
    
    @Override
    protected void before() throws Throwable {        
        this.app = SpringApplication.run(App.class);
    }
    
    @Override
    protected void after() {
       app.close();
    }
    
}
