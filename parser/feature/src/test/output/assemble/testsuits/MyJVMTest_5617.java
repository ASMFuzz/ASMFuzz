import java.io.File;

public class MyJVMTest_5617 {

    static int[] array = { 9, 0, 1246529059, 0, -891404944, 5, 0, 0, 9, 1 };

    static int p = 321829697;

    static int inc = 8;

    int arrMethod(int[] array, int p, int inc) {
        array[p] += inc;
        return inc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5617().arrMethod(array, p, inc);
    }
}
