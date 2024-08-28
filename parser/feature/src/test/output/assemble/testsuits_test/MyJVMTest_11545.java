public class MyJVMTest_11545 {

    static int i = 4;

    int simpleb2(int i) {
        Integer ib1 = Integer.valueOf(i);
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11545().simpleb2(i));
    }
}
