package DsLab;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Queue;

public interface PrinterI extends Remote {

    void print(String filename, String printer) throws RemoteException;
    // Add the filename to the queue of the printer

    Queue<String> queue(String printer) throws RemoteException;
    // Display the current queue on the specified printer

    void topQueue(String printer, int job) throws RemoteException;
    // Moves the job to the top of the queue

    void start() throws RemoteException;
    // Start the server

    void stop() throws RemoteException;
    // Stop the server

    void restart() throws RemoteException;
    // Stop the server, clears the queue and restarts the server

    void status(String printer) throws RemoteException;
    // display the status of printer to the user

    void readConfig(String parameter) throws RemoteException;
    // prints the value of the parameter on the print server tot the user's display

    void setConfig(String parameter,String valueString) throws RemoteException;
    // sets the parameter on the print server to value
}
