import java.util.*;

public class MyJVMTest_1734 {

    static int constraint1 = -957253455;

    static int constraint2 = 0;

    static Random generator = new Random();

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt();
        return constraint1 + Math.abs(x % range);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1734().getRandomIndex(constraint1, constraint2));
    }
}
