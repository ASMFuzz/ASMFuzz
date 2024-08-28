import java.util.Random;

public class MyJVMTest_6937 {

    Long getSystemSeed() {
        Long seed = null;
        try {
            seed = Long.valueOf(System.getProperty("seed"));
        } catch (NumberFormatException e) {
        }
        return seed;
    }

    long getSeed() {
        Long seed = getSystemSeed();
        if (seed == null) {
            seed = (new Random()).nextLong();
        }
        System.out.println("Seed from AbstractRandomTest.getSeed = " + seed + "L");
        return seed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6937().getSeed());
    }
}
