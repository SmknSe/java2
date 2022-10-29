package practice23_24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transaction {
    private String id;
    private String company;
    private String balance;
    private String profit;
    private String expense;
    private String total;

    private float getNumber(String str) {
        Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        return Float.valueOf(matcher.group());
    }

    public String getCompany() {
        return company;
    }

    public float getBalance(){
        return getNumber(balance);
    }

    public float getProfit(){
        return getNumber(profit);
    }

    public float getExpense(){
        return getNumber(expense);
    }

    public float getTotal(){
        return getNumber(total);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", balance='" + balance + '\'' +
                ", profit='" + profit + '\'' +
                ", expense='" + expense + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
