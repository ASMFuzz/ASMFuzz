public class MyJVMTest_2453 {

    static Integer ibc = new Integer(1);

    int remi_sumc() {
        Integer j = ibc;
        for (int i = 0; i < 1000; i++) {
            j = j + ibc;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2453().remi_sumc());
    }
}
