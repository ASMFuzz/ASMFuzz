public class MyJVMTest_8539 {

    static String dataModel = System.getProperty("sun.arch.data.model");

    boolean is32bit() {
        return dataModel.equals("32");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8539().is32bit());
    }
}
