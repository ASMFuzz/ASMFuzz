import java.util.Random;

public class MyJVMTest_5684 {

    static int min = -541313594;

    static int max = 0;

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    static Random generator = new Random();

    StringBuilder generateTestBuilder(int min, int max) {
        StringBuilder aNewStringBuilder = new StringBuilder(120);
        int aNewLength = getRandomIndex(min, max);
        for (int y = 0; y < aNewLength; y++) {
            int achar = generator.nextInt(30) + 30;
            char test = (char) (achar);
            aNewStringBuilder.append(test);
        }
        return aNewStringBuilder;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5684().generateTestBuilder(min, max));
    }
}
