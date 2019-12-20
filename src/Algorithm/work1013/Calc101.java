package Algorithm.work1013;

public class Calc101 {
    public int calc(int a){
        int result = 0, i = 0, j = 0;
        for(int k = a; k > 0; k--){
            if(j > 0)
                j = k * 10 + j;
            else
                j = k;
            while (j >= 10){
                int t = j % 100;
                j = j / 100;
                result = ((i++ % 2 == 0) ? result - t : result + t);
            }
        }
        if(j > 0)
            result = ((i++ % 2 == 0) ? result - j : result + j);
        return result;
    }

    public static void main(String[] args) {
        Calc101 calc101 = new Calc101();
        System.out.println(calc101.calc(101));
    }
}
