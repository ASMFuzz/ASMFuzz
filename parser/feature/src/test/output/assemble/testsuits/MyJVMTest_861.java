public class MyJVMTest_861 {

    static int i = m();

    static int j = 0;

    int m() {
        j = 5;
        return j++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_861().m());
    }
}
