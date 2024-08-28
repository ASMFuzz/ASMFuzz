import java.lang.reflect.Array;

public class MyJVMTest_7348 {

    void zeroDimension() throws Exception {
        try {
            Array.newInstance(Integer.TYPE, new int[0]);
        } catch (IllegalArgumentException iae) {
            System.out.println("success: zeroDimension test");
            return;
        }
        throw new Exception("MultiNewArray allowed dimension == 0");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7348().zeroDimension();
    }
}
