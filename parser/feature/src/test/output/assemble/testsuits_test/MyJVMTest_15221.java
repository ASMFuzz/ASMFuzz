import java.util.*;

public class MyJVMTest_15221 {

    static List<Long> list = new ArrayList<Long>();

    void doWork() {
        int primeCount = 0;
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            long number = System.nanoTime() % 1000000;
            list.add(Long.valueOf(number));
        }
        for (Long value : list) {
            long counter = 2;
            long val = value.longValue();
            boolean isPrime = true;
            for (counter = 2; counter < val; counter++) {
                if (val % counter == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                primeCount += 1;
            }
        }
        System.out.println("Prime numbers in the list: " + primeCount);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15221().doWork();
    }
}
