import java.util.Random;

public class MyJVMTest_2843 {

    Random returnRandom() {
        return new Random();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2843().returnRandom());
    }
}
