public class MyJVMTest_7650 {

    static K k = null;

    <K> String genericMethod2(K k) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7650().genericMethod2(k));
    }
}
