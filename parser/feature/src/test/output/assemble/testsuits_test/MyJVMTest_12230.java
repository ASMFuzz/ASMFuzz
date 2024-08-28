public class MyJVMTest_12230 {

    static String classname = "lS-vpJG=Nc";

    static String methodname = "U.qWJ[D~$G";

    String getFileName() {
        int i = classname.lastIndexOf('.');
        int j = classname.lastIndexOf('$');
        String name = classname.substring(i + 1, j >= 0 ? j : classname.length());
        return name + ".java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12230().getFileName());
    }
}
