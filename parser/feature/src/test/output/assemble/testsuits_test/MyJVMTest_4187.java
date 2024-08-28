public class MyJVMTest_4187 {

    static String classId = "C3wh!''w1]";

    static String classFileName = "WnIr>J^6fL";

    static String cmd = "b 8B>R]n5]";

    JdbCommand redefine(String classId, String classFileName) {
        return new JdbCommand("redefine " + classId + " " + classFileName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4187().redefine(classId, classFileName));
    }
}
