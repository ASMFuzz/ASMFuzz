public class MyJVMTest_10040 {

    static int i = m();

    static int j = 0;

    int m() {
        j = 5;
        return j++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10040().m());
    }
}
