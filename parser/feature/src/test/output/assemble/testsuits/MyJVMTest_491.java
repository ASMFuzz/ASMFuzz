import java.util.Random;

public class MyJVMTest_491 {

    static int constraint1 = -662452442;

    static int constraint2 = 1;

    static Random generator = new Random();

    static int length = 8;

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_491().getRandomIndex(constraint1, constraint2));
    }
}
