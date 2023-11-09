package Singleton;

public class PrinterPoolLazy {
    private static PrinterPoolLazy instance;

    private PrinterPoolLazy () {
        // Printerpool Code
    }

    public static PrinterPoolLazy getInstance() {
        if (instance == null) {
            instance = new PrinterPoolLazy();
        }
        return instance;
    }
}
