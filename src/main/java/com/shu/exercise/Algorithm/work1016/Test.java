package Algorithm.work1016;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A{
    public void aPrint(){
        System.out.println("a");
    }
}

class B extends A{
    public void bPrint(){
        System.out.println("b");
    }
}

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a = new B();
        Class<? extends A> aClass = a.getClass();
        Method bPrint = aClass.getDeclaredMethod("bPrint");
        bPrint.invoke(a);
    }
}
