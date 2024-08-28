public class MyJVMTest_8112 {

    boolean validatePlatform() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            throw new RuntimeException("Name of the current OS could not be" + " retrieved.");
        }
        return osName.startsWith("Windows");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8112().validatePlatform());
    }
}
