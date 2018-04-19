package laullobet.org;

public class TransactionFormatter {
    public String format(Transaction transaction, int balance) {
        if(transaction.getAmount() > 0){
            return transaction.getDate()+" || "+transaction.getAmount()+".00 || || "+ balance +".00";
        }
        return transaction.getDate()+" || || "+-transaction.getAmount()+".00 || "+balance+".00";
    }
}
