public class MyJVMTest_13107 {

    static int i = 2;

    static Integer ib1 = -1572791173;

    int simplep2(int i, Integer ib1) {
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13107().simplep2(i, ib1));
    }
}
