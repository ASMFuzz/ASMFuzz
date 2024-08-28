public class MyJVMTest_17438 {

    static Integer j = 872549967;

    int remi_sump(Integer j) {
        for (int i = 0; i < 1000; i++) {
            j = new Integer(j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17438().remi_sump(j));
    }
}
