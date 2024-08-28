public class MyJVMTest_12493 {

    boolean validatePlatform() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            throw new RuntimeException("Name of the current OS could not be" + " retrieved.");
        }
        return osName.startsWith("Mac");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12493().validatePlatform());
    }
}
