public class MyJVMTest_5312 {

    static int i = 7;

    int simpleb(int i) {
        Integer ib = Integer.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5312().simpleb(i));
    }
}
