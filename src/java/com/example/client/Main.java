/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.client;
import com.example.common.HelloWorld;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author yandypiedra
 */
public class Main {

    @EJB
    private static HelloWorld proxy;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        System.out.println("Lookup: "+lookup().sayHello("Ejb"));
        System.out.println("Injection: "+proxy.sayHello("Ejb"));
    }
    
    
    // lookup for this proxy
    private static HelloWorld lookup() throws NamingException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        Context ctx = new InitialContext(props);
        return (HelloWorld) ctx.lookup("java:global/ejb-example/HelloWorldEJB");
    }
    
}
