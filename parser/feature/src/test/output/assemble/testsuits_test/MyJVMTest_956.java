public class MyJVMTest_956 {

    static int i = -2117431149;

    static Integer ibc = new Integer(1);

    int simplec2(int i) {
        Integer ib1 = ibc;
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_956().simplec2(i));
    }
}
