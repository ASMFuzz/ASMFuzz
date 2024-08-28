public class MyJVMTest_2467 {

    Long getSystemSeed() {
        Long seed = null;
        try {
            seed = Long.valueOf(System.getProperty("seed"));
        } catch (NumberFormatException e) {
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2467().getSystemSeed());
    }
}
