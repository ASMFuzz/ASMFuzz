public class MyJVMTest_6544 {

    static K k = null;

    <K> String genericMethod5(K k) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6544().genericMethod5(k));
    }
}
