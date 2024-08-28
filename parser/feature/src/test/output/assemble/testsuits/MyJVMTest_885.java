import java.util.Random;

public class MyJVMTest_885 {

    Random random() {
        return rand;
    }

    static Random rand = null;

    boolean fiftyfifty() {
        return random().nextInt(10) >= 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_885().fiftyfifty());
    }
}
