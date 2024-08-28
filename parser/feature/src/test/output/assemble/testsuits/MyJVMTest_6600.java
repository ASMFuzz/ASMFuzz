import java.lang.reflect.Array;

public class MyJVMTest_6600 {

    Object getArrayOf256Dimensions() {
        Object o = Array.newInstance(Integer.TYPE, 0);
        for (int i = 1; i <= 254; i++) {
            o = Array.newInstance(o.getClass(), 1);
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6600().getArrayOf256Dimensions());
    }
}
