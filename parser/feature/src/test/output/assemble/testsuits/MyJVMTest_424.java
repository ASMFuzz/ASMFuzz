public class MyJVMTest_424 {

    static String dataModel = System.getProperty("sun.arch.data.model");

    boolean is64bit() {
        return dataModel.equals("64");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_424().is64bit());
    }
}
