import java.rmi.*;
import java.rmi.activation.*;
import java.io.*;

public class MyJVMTest_16536 {

    static Remote remoteObject = null;

    static ActivationID activationID = null;

    void run() {
        try {
            Activatable.unexportObject(remoteObject, true);
            Activatable.inactive(activationID);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16536().run();
    }
}
