import java.beans.PropertyChangeEvent;

public class MyJVMTest_14421 {

    static String errorParam1 = "^91}IvEu0B";

    static String errorParam2Param1Param1Param1 = "py] JDjvQ3";

    static Throwable errorParam2Param1Param1 = new Throwable(errorParam2Param1Param1Param1);

    static Throwable errorParam2Param1 = new Throwable(errorParam2Param1Param1);

    static Throwable errorParam2 = new Throwable(errorParam2Param1);

    static boolean errorParam3 = true;

    static boolean errorParam4 = true;

    static Throwable error = new Throwable(errorParam1, errorParam2, errorParam3, errorParam4);

    static boolean failed = true;

    Throwable print(Throwable error) {
        error.printStackTrace();
        failed = true;
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14421().print(error);
    }
}
