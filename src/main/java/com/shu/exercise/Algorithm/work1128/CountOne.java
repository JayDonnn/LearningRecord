package Algorithm.work1128;

public class CountOne {

    public int hammingWeight(int n) {
        int oneCnt = 0;
        while (n != 0) {
            n = (n & (n - 1)) >> 1;
            oneCnt++;
        }
        return oneCnt;
    }

    public boolean isPowerOfTwo(int n) {
        if(n < 0) n = -n;
        return n == 0 ? false : (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        CountOne countOne = new CountOne();
        countOne.hammingWeight(10);
    }
}
