import java.util.*;

public class MyJVMTest_10957 {

    static int constraint1 = 9;

    static int constraint2 = 5;

    static Random generator = new Random();

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt();
        return constraint1 + Math.abs(x % range);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10957().getRandomIndex(constraint1, constraint2));
    }
}
