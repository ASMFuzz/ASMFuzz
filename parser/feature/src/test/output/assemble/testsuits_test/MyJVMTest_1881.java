public class MyJVMTest_1881 {

    void checkNulls() throws Exception {
        StringBuffer sb1 = new StringBuffer();
        CharSequence cs = null;
        sb1.append("test");
        sb1.append(cs);
        if (!sb1.toString().equals("testnull"))
            throw new RuntimeException("StringBuffer.append failure 3");
        sb1 = new StringBuffer();
        sb1.append("test", 0, 2);
        sb1.append(cs, 0, 2);
        if (!sb1.toString().equals("tenu"))
            throw new RuntimeException("StringBuffer.append failure 4");
        sb1 = new StringBuffer("test");
        sb1.insert(2, cs);
        if (!sb1.toString().equals("tenullst"))
            throw new RuntimeException("StringBuffer.insert failure 3");
        sb1 = new StringBuffer("test");
        sb1.insert(2, cs, 0, 2);
        if (!sb1.toString().equals("tenust"))
            throw new RuntimeException("StringBuffer.insert failure 4");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1881().checkNulls();
    }
}
