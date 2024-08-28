public class MyJVMTest_3493 {

    String getJDKRoot() {
        String jdkPath = System.getProperty("test.jdk");
        if (jdkPath == null) {
            throw new RuntimeException("System property 'test.jdk' not set. This property is normally set by jtreg. " + "When running test separately, set this property using '-Dtest.jdk=/path/to/jdk'.");
        }
        return jdkPath;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3493().getJDKRoot());
    }
}
