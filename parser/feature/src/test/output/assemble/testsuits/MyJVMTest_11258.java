public class MyJVMTest_11258 {

    static K key = null;

    static V value = null;

    V put(K key, V value) {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11258().put(key, value));
    }
}
