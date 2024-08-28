import java.lang.reflect.Array;

public class MyJVMTest_12773 {

    Object getArrayOf256Dimensions() {
        Object o = Array.newInstance(Integer.TYPE, 0);
        for (int i = 1; i <= 254; i++) {
            o = Array.newInstance(o.getClass(), 1);
        }
        return o;
    }

    void newInstanceOne() throws Exception {
        Object o = getArrayOf256Dimensions();
        try {
            o = Array.newInstance(o.getClass(), 1);
        } catch (IllegalArgumentException iae) {
            System.out.println("success: newInstanceOne test");
            return;
        }
        throw new Exception("NewArray allowed dimensions > MAXDIM");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12773().newInstanceOne();
    }
}
