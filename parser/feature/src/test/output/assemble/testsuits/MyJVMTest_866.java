import java.io.*;

public class MyJVMTest_866 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int i = 7;

    static int[] tmp = {3,2,0,0,9,9,7,0,0,-414098566};

    ObjectInputStream readObjectCleanup(ObjectInputStream pr) {
        System.err.println("\nCleanup called on abort");
        if (tmp != null) {
            tmp = null;
        }
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_866().readObjectCleanup(pr);
    }
}
