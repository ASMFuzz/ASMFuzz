import java.util.Random;

public class MyJVMTest_10528 {

    long getRandomSeed() {
        return new Random().nextLong();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10528().getRandomSeed());
    }
}
