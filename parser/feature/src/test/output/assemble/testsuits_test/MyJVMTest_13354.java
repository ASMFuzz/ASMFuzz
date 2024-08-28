public class MyJVMTest_13354 {

    static String classId = ";Em~ov&$*\"";

    static String fieldName = "ii/,mj*1|[";

    static String cmd = ":!caD2)NC:";

    JdbCommand watch(String classId, String fieldName) {
        return new JdbCommand("watch " + classId + "." + fieldName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13354().watch(classId, fieldName));
    }
}
