public class MyJVMTest_13550 {

    static String classId = "akPzmhjq*t";

    static String classFileName = ".Oj)vC,iL;";

    static String cmd = "*)m'-Fl r/";

    JdbCommand redefine(String classId, String classFileName) {
        return new JdbCommand("redefine " + classId + " " + classFileName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13550().redefine(classId, classFileName));
    }
}
