public class MyJVMTest_2017 {

    static K key = null;

    static V value = null;

    V put(K key, V value) {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2017().put(key, value));
    }
}
