public class MyJVMTest_2286 {

    static int i = 1;

    int simpleb2(int i) {
        Integer ib1 = Integer.valueOf(i);
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2286().simpleb2(i));
    }
}
