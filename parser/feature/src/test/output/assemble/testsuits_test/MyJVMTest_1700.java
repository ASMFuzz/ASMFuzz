public class MyJVMTest_1700 {

    static Integer ibc = new Integer(1);

    int simplec() {
        Integer ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1700().simplec());
    }
}
