import javax.crypto.CipherSpi;

public class MyJVMTest_4796 {

    int engineGetBlockSize() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4796().engineGetBlockSize());
    }
}
