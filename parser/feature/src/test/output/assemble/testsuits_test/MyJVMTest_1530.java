public class MyJVMTest_1530 {

    static Short ibc = new Short((short) 1);

    short simplec() {
        Short ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1530().simplec());
    }
}
