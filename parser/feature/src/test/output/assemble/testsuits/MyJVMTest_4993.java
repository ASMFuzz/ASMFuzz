public class MyJVMTest_4993 {

    static String relfilename = "uKg=[2dVR<";

    String resolve(String relfilename) {
        String dir = System.getProperty("test.src");
        if (dir == null) {
            return relfilename;
        } else {
            return dir + "/" + relfilename;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4993().resolve(relfilename));
    }
}
