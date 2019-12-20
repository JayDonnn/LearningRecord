package Algorithm.work1023;

public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1(){};
    public static Singleton1 getInstance(){
        if(instance == null)
            instance =  new Singleton1();
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 s1, s2;
        s1 = Singleton1.getInstance();
        s2 = Singleton1.getInstance();
        if(s1 == s2)
            System.out.println("1");
    }
}
