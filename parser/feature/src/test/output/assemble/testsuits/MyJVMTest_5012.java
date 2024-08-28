import java.beans.PropertyChangeEvent;

public class MyJVMTest_5012 {

    static String errorParam1 = "XdXe.5F6gx";

    static Throwable error = new Throwable(errorParam1);

    static boolean failed = false;

    Throwable print(Throwable error) {
        error.printStackTrace();
        failed = true;
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5012().print(error);
    }
}
