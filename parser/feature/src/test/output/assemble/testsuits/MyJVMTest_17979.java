public class MyJVMTest_17979 {

    static Object in = 4;

    String foo(Object in) {
        return "a";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17979().foo(in));
    }
}
