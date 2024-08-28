public class MyJVMTest_8844 {

    static long a = 0;

    static long b = 4730734726163075534L;

    static long c = -8806764120430187791L;

    long test(long a, long b, long c) {
        return a * b - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8844().test(a, b, c));
    }
}
