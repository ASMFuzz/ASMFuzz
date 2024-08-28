public class MyJVMTest_2929 {

    static String classname = "DYX{LCQ#&]";

    static String methodname = "|G+HB)e*!+";

    String getFileName() {
        int i = classname.lastIndexOf('.');
        int j = classname.lastIndexOf('$');
        String name = classname.substring(i + 1, j >= 0 ? j : classname.length());
        return name + ".java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2929().getFileName());
    }
}
