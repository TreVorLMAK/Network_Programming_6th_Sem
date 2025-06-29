package com.myrmi;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            HelloImpl helloService = new HelloImpl();
            Naming.rebind("rmi://localhost:1099/HelloService", helloService);
            System.out.println("Server is ready and waiting for client requests...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
