import java.util.Random;

public class MyJVMTest_7008 {

    Long getSystemSeed() {
        Long seed = null;
        try {
            seed = Long.valueOf(System.getProperty("seed"));
        } catch (NumberFormatException e) {
        }
        return seed;
    }

    long getRandomSeed() {
        return new Random().nextLong();
    }

    long getSeed() {
        Long seed = getSystemSeed();
        if (seed == null) {
            seed = getRandomSeed();
        }
        System.out.println("Seed from RandomFactory = " + seed + "L");
        return seed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7008().getSeed());
    }
}
