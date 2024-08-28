public class MyJVMTest_3768 {

    static int i = 6;

    static Integer ib1 = 2;

    int simplep2(int i, Integer ib1) {
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3768().simplep2(i, ib1));
    }
}
