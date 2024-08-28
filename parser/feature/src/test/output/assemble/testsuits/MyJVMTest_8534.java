import java.io.*;

public class MyJVMTest_8534 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int[] tmp = {708197787,0,-1452168838,5,0,508751685,-647121853,455781768,3,1};

    ObjectInputStream readObjectCleanup(ObjectInputStream pr) {
        System.err.println("\nPickleClass cleanup correctly called on abort.");
        if (tmp != null) {
            tmp = null;
        }
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8534().readObjectCleanup(pr);
    }
}
