public class MyJVMTest_14400 {

    static String relfilename = "X4$'7<V:dA";

    String resolve(String relfilename) {
        String dir = System.getProperty("test.src");
        if (dir == null) {
            return relfilename;
        } else {
            return dir + "/" + relfilename;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14400().resolve(relfilename));
    }
}
