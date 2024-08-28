import java.net.*;

public class MyJVMTest_994 {

    static ServerSocket server = null;

    static boolean isFinished = false;

    boolean finished() {
        return (isFinished);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_994().finished());
    }
}
