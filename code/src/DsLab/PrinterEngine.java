package DsLab;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Queue;

public class PrinterEngine implements PrinterI {

    public PrinterEngine() {
        super();
    }

    @Override
    public void print(String filename, String printer) throws RemoteException {
        System.out.println("Print method for - " + filename + "\nCalled on --- " + printer );
}

    @Override
    public Queue<String> queue(String printer) throws RemoteException {
        System.out.println("Queue method called " + printer);
        return printer.queue;
}

    @Override
    public void topQueue(String printer, int job) throws RemoteException {
        System.out.println("TopQueue method called " + printer + job);
    }

    @Override
    public void start() throws RemoteException {
        System.out.println("Start");
    }

    @Override
    public void stop() throws RemoteException {
        System.out.println("Stop");
    }

    @Override
    public void restart() throws RemoteException {
        System.out.println("restarting");
    }

    @Override
    public void status(String printer) throws RemoteException {
        System.out.println("Status method called " + printer);}

    @Override
    public void readConfig(String parameter) throws RemoteException {
        System.out.println("readConfig method called " + parameter);
    }

    @Override
    public void setConfig(String parameter, String valueString) throws RemoteException {
        System.out.println("setConfig method called " + parameter + valueString);
    }

    public static void main(String[] args) {
        try {
        String name = "Printer Engine";
        PrinterI printer = new PrinterEngine();
        PrinterI stub = (PrinterEngine) UnicastRemoteObject.exportObject(printer,6996);
        Registry registry = LocateRegistry.getRegistry();
        registry.rebind(name, stub);
        System.err.println("Printer Engine bound");
        
        }
        catch ( Exception e){
            System.err.println("Printer Engine Exception:");
            e.printStackTrace();
        }

    }
}
