import java.util.Random;

public class MyJVMTest_9651 {

    static int constraint1 = 6;

    static int constraint2 = 1737066416;

    static Random generator = new Random();

    static int length = 0;

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9651().getRandomIndex(constraint1, constraint2));
    }
}
