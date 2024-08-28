public class MyJVMTest_12583 {

    static K k = null;

    <K> String genericMethod3(K k) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12583().genericMethod3(k));
    }
}
