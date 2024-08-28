import java.net.*;

public class MyJVMTest_10182 {

    static ServerSocket server = null;

    static boolean isFinished = false;

    boolean finished() {
        return (isFinished);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10182().finished());
    }
}
