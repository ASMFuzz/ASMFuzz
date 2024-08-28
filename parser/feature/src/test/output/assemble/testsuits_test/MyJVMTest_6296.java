public class MyJVMTest_6296 {

    static Other other = null;

    int m(Other other) {
        return other.i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6296().m(other));
    }
}
