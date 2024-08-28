public class MyJVMTest_3262 {

    static K k = null;

    <K> String genericMethod3(K k) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3262().genericMethod3(k));
    }
}
