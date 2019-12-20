package Algorithm.work1016;

import java.util.Scanner;

class PrizePool{
    public void send(String input){
        System.out.print(input);
    }
}

class ReviewEncourage implements Runnable{
    private int n;
    private volatile int i;
    private volatile String lastPrint;
    private PrizePool prizePool;

    public ReviewEncourage(int n) {
        this.n = n;
        this.i = 1;
        prizePool = new PrizePool();
    }

    public void bonus(PrizePool prizePool) {
        while (true){
            synchronized (this){
                if(i > n){
                    this.notifyAll();
                    break;
                }
                if(i <= n && i % 2 != 0){
                    prizePool.send("A");
                    i++;
                }
                this.notifyAll();
            }
        }
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) {
        while (true){
            synchronized (this){
                if(i > n){
                    this.notifyAll();
                    break;
                }
                if(i <= n && i % 2 == 0 && (lastPrint == null || lastPrint.equals("C"))){
                    prizePool.send("B");
                    i++;
                }
                this.notifyAll();
            }
        }
    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) {
        while (true){
            synchronized (this){
                if(i > n){
                    this.notifyAll();
                    break;
                }
                if(i <= n && i % 2 == 0 && lastPrint.equals("B")){
                    prizePool.send("C");
                    i++;
                }
                this.notifyAll();
            }
        }
    }  // 仅能打印C，表示发放贡献值

    @Override
    public void run() {
        bonus(prizePool);
        coupon(prizePool);
        contribution(prizePool);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0 || n > 100){
            return;
        }
        ReviewEncourage reviewEncourage = new ReviewEncourage(100);
        Thread thread1 = new Thread(reviewEncourage);
        Thread thread2 = new Thread(reviewEncourage);
        Thread thread3 = new Thread(reviewEncourage);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
