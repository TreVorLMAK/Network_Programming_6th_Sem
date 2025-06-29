package com.myrmi;
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Hello helloService = (Hello) Naming.lookup("rmi://localhost:1099/HelloService");
            String message = helloService.sayHello();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
