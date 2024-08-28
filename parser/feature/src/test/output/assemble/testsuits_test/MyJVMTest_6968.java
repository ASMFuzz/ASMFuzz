public class MyJVMTest_6968 {

    static int shortFall = 7;

    int available() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6968().available());
    }
}
