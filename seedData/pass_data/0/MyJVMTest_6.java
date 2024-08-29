import java.util.Random;

public class MyJVMTest_6 {

    static int nextIndex = -1765391063;

    static Random rand = null;

    Random rand() {
        rand.setSeed(nextIndex);
        return rand;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6().rand());
    }
}
