import java.util.Random;

public class MyJVMTest_12691 {

    static int constraint1 = 1;

    static int constraint2 = 5;

    static Random generator = new Random();

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12691().getRandomIndex(constraint1, constraint2));
    }
}
