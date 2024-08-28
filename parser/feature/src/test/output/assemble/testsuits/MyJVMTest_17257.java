import java.lang.reflect.Array;

public class MyJVMTest_17257 {

    static Class<?>[] classes = null;

    static int start = -1385705455;

    static String[] result = {"FQNMTZEtD5","J)dk20Mp31","/T}?GyYR5O","g\"DCV8tJ9~","-b3k/8GoTV",">t3?s%Z-lu","mwZetF,m@N","Mp}egj-4:$","y\"kaEDyX}A","NwGr86pb(9"};

    void run() {
        result = new String[classes.length];
        System.err.print('.');
        for (int i = start; i < classes.length; i++) {
            result[i] = Array.newInstance(classes[i], 0).getClass().getName();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17257().run();
    }
}
