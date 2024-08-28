import java.util.Random;

public class MyJVMTest_3363 {

    static int constraint1 = 4;

    static int constraint2 = 1437140302;

    static Random generator = new Random();

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3363().getRandomIndex(constraint1, constraint2));
    }
}
