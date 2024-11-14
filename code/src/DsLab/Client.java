package DsLab;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String args[]) {
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            PrinterI printer = (PrinterI) registry.lookup(name);
            // need to add some stuff to actually executes
            System.out.println("Client created");
        } catch (Exception e) {
            System.err.println("Client exception:");
            e.printStackTrace();
        }
    }    
}

