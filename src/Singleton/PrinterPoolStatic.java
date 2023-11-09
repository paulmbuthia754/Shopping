package Singleton;

public class PrinterPoolStatic {
    private static PrinterPoolStatic instance;

    // static block initialisation for exception handling

    private PrinterPoolStatic () {
        // PrinterPool Code
    }

    static {
        try {
            instance = new PrinterPoolStatic();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating PrinterPool instance");
        }
    }

    public static PrinterPoolStatic getInstance() {
        return instance;
    }
}