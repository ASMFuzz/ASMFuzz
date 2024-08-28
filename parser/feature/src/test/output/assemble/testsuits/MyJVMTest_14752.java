import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.tools.*;

public class MyJVMTest_14752 {

    void checkCreateClassLoader() {
        throw new SecurityException("Not today, thanks you!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14752().checkCreateClassLoader();
    }
}
