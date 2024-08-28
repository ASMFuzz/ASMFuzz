import java.util.Random;

public class MyJVMTest_12139 {

    Random returnRandom() {
        return new Random();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12139().returnRandom());
    }
}
