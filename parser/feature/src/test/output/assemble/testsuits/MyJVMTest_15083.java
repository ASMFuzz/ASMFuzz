public class MyJVMTest_15083 {

    static String classId = "xH#\\&bI-}7";

    static String cmd = "uCwl'-\"[5:";

    JdbCommand methods(String classId) {
        return new JdbCommand("methods " + classId);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15083().methods(classId));
    }
}
