import java.io.File;

public class MyJVMTest_12104 {

    String getDirURL() {
        return new File(System.getProperty("test.src", ".")).getAbsolutePath() + File.separator;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12104().getDirURL());
    }
}
