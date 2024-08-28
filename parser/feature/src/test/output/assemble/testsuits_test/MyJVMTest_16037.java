public class MyJVMTest_16037 {

    static K k = null;

    <K> String genericMethod5(K k) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16037().genericMethod5(k));
    }
}
