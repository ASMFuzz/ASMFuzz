public class MyJVMTest_15774 {

    static Other other = null;

    int m(Other other) {
        return other.i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15774().m(other));
    }
}
