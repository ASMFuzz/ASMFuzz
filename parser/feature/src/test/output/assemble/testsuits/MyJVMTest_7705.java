import java.lang.reflect.Array;

public class MyJVMTest_7705 {

    static Class<?>[] classes = null;

    static int start = 0;

    static String[] result = {"-TwlZ].ZO\\","5i:Y8]4DaD","y]w_3F:V`G","2l5j8+Q!q;","E3IH{+z4h9","^UEqvJ+Imh","1XD$2y&sgy","xv;+[SoYfO","u&Y\\n>==D{","!*ouO^zmk!"};

    void run() {
        result = new String[classes.length];
        System.err.print('.');
        for (int i = start; i < classes.length; i++) {
            result[i] = Array.newInstance(classes[i], 0).getClass().getName();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7705().run();
    }
}
