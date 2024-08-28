public class MyJVMTest_8540 {

    String getAlgorithm() {
        return ("non_matching_alg");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8540().getAlgorithm());
    }
}
