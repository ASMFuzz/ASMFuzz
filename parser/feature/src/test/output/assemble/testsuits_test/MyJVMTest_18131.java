public class MyJVMTest_18131 {

    String getAlgorithm() {
        return ("non_matching_alg");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18131().getAlgorithm());
    }
}
