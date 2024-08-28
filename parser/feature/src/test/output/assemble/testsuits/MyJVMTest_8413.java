import java.util.Random;

public class MyJVMTest_8413 {

    static int min = 2;

    static int max = 0;

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    static Random generator = new Random();

    StringBuffer generateTestBuffer(int min, int max) {
        StringBuffer aNewStringBuffer = new StringBuffer(120);
        int aNewLength = getRandomIndex(min, max);
        for (int y = 0; y < aNewLength; y++) {
            int achar = generator.nextInt(30) + 30;
            char test = (char) (achar);
            aNewStringBuffer.append(test);
        }
        return aNewStringBuffer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8413().generateTestBuffer(min, max));
    }
}
