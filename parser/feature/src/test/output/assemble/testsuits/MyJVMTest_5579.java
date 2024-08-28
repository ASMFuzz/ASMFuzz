public class MyJVMTest_5579 {

    static String userName = System.getProperty("user.name");

    boolean canAttachOSX() {
        return userName.equals("root");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5579().canAttachOSX());
    }
}
