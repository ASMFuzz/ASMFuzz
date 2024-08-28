public class MyJVMTest_15015 {

    static String userName = System.getProperty("user.name");

    boolean canAttachOSX() {
        return userName.equals("root");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15015().canAttachOSX());
    }
}
