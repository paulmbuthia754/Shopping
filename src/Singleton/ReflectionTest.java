package Singleton;

import java.lang.reflect.Constructor;

public class ReflectionTest {
   public static void main(String[] args) {
        PrinterPoolEager instanceNormal = PrinterPoolEager.getInstance();
        PrinterPoolEager instanceEvil = null;
        PrinterPoolEager instanceEvil2 = null;
        PrinterPoolEager instanceEvil3 = null;
        
        try {
            Constructor constructor = instanceNormal.getClass().getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);

            instanceEvil3 = (PrinterPoolEager) constructor.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class[] paramTypes = null;
            Constructor<PrinterPoolEager> cons = PrinterPoolEager.class.getDeclaredConstructor(paramTypes);
            instanceEvil = (PrinterPoolEager) cons.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Constructor[] constructors = PrinterPoolEager.class.getConstructors();
            for(Constructor constructor_: constructors) {
                // Change this constructor from private to public
                constructor_.setAccessible(true);
                instanceEvil2 = (PrinterPoolEager) constructor_.newInstance(); // Like calling new PrinterPoolEager()
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Normal intance: " + instanceNormal.hashCode());
        System.out.println("Evil instance: " + instanceEvil3.hashCode());
        System.out.println("Evil instance: " + instanceEvil2.hashCode());
        System.out.println("Evil instance: " + instanceEvil.hashCode());
   } 
}
