package Algorithm.work1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamExercise {

    // 1.找出2011年发生的所有交易，并按交易额排序（从低到高）
    public List<Transaction> getAllTransactionIn2011(List<Transaction> transactions) {
        return transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue)).collect(Collectors.toList());
    }

    // 2.交易员都在哪些不同的城市工作过？
    public List<String> getAllCityOfTrader(List<Trader> traders) {
        return traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList());
    }

    // 4.返回所有交易员的姓名字符串，按字母顺序排序。
    public void printNameOfTrader(List<Trader> traders) {
        traders.stream().map(Trader::getName).forEach(System.out::println);
    }

    // 7.所有交易中，最高的交易额是多少？
    public int getTopValue(List<Transaction> transactions) {
        return transactions.stream().sorted(comparing(Transaction::getValue).reversed()).limit(1)
                .map(Transaction::getValue).reduce(0, (a, b) -> a + b);
    }
    // 8.找到交易额最小的交易。
    public Optional<Transaction> getMinimumTransaction(List<Transaction> transactions) {
        return transactions.stream().sorted(comparing(Transaction::getValue)).findFirst();
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 3.查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> traders = transactions.stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getCity())).collect(Collectors.toList());
        System.out.println(traders);

        // 5.有没有交易员是在米兰工作的？
        boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        // 6.打印生活在剑桥的交易员的所有交易额。
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).forEach(transaction -> System.out.println(transaction.getValue()));

        // 7.所有交易中，最高的交易额是多少？
        int highestValue = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        System.out.println(highestValue);

        Optional<Transaction> smallestTransaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> minimum = transactions.stream().min(comparing(Transaction::getValue));

        transactions.stream().collect(Collectors.mapping(Transaction::getValue, Collectors.toCollection(ArrayList::new))).forEach(System.out::println);
    }
}
