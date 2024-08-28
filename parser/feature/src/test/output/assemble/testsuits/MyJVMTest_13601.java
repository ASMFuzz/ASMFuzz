public class MyJVMTest_13601 {

    static String classId = "} ^v7q5Bv`";

    static String cmd = "]YbG,sKW%Z";

    JdbCommand ignore(String classId) {
        return new JdbCommand("ignore " + classId);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13601().ignore(classId));
    }
}
