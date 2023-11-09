package Singleton;

public class PrinterPoolLazyThreadSafe {
    private static PrinterPoolLazyThreadSafe instance;

    private PrinterPoolLazyThreadSafe () {
        // Printerpool code
    }

    public static synchronized PrinterPoolLazyThreadSafe getIntance() {
        if (instance == null) {
            instance = new PrinterPoolLazyThreadSafe();
        }
        return instance;
    }

    // Double checked synchronisation to improve performance
    public static PrinterPoolLazyThreadSafe getDoubleCheckedInstance() {
        if (instance == null) {
            synchronized (PrinterPoolLazyThreadSafe.class) {
                if (instance == null) {
                    instance = new PrinterPoolLazyThreadSafe();
                }
            }
        }
        return instance;
    }
}
