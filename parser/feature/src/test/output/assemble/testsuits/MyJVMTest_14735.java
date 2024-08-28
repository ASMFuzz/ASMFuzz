public class MyJVMTest_14735 {

    static int i = 9;

    int simpleb(int i) {
        Integer ib = Integer.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14735().simpleb(i));
    }
}
