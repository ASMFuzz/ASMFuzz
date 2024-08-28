import java.util.Random;

public class MyJVMTest_17714 {

    static int min = -1897843875;

    static int max = 1173113346;

    int getRandomIndex(int constraint1, int constraint2) {
        int range = constraint2 - constraint1;
        int x = generator.nextInt(range);
        return constraint1 + x;
    }

    static Random generator = new Random();

    StringBuffer generateTestBuffer(int min, int max) {
        StringBuffer aNewStringBuffer = new StringBuffer();
        int aNewLength = getRandomIndex(min, max);
        for (int y = 0; y < aNewLength; y++) {
            int achar = generator.nextInt(30) + 30;
            char test = (char) (achar);
            aNewStringBuffer.append(test);
        }
        return aNewStringBuffer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17714().generateTestBuffer(min, max));
    }
}
