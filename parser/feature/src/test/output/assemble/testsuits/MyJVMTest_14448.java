import java.lang.reflect.Array;

public class MyJVMTest_14448 {

    Object getArrayOf256Dimensions() {
        Object o = Array.newInstance(Integer.TYPE, 0);
        for (int i = 1; i <= 254; i++) {
            o = Array.newInstance(o.getClass(), 1);
        }
        return o;
    }

    void newInstanceMulti() throws Exception {
        Object o = getArrayOf256Dimensions();
        try {
            o = Array.newInstance(o.getClass(), new int[] { 1, 1 });
            o = Array.newInstance(o.getClass(), new int[] { 1 });
        } catch (IllegalArgumentException iae) {
            System.out.println("success: newInstanceMulti test");
            return;
        }
        throw new Exception("MultiNewArray allowed dimensions > MAXDIM");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14448().newInstanceMulti();
    }
}
