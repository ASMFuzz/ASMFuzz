public class MyJVMTest_4685 {

    void usageError() {
        System.err.println("Usage: FileBuilder filetype filename filesize");
        System.err.println("");
        System.err.println("Makes a file named FILENAME of size FILESIZE.");
        System.err.println("If FILETYPE is \"MostlyEmpty\", the file contents is mostly null bytes");
        System.err.println("(which might occupy no disk space if the right OS support exists).");
        System.err.println("If FILETYPE is \"SlightlyCompressible\", the file contents are");
        System.err.println("approximately 90% random data.");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4685().usageError();
    }
}
