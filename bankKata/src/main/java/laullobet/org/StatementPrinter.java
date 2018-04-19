package laullobet.org;

import java.util.ArrayList;

public class StatementPrinter extends ArrayList<Transaction> {

    private final Console console;
    private final TransactionFormatter transactionFormatter;

    public StatementPrinter(Console console, TransactionFormatter transactionFormatter) {

        this.console = console;
        this.transactionFormatter = transactionFormatter;
    }

    public void print() {
        console.println("date || credit || debit || balance");

        int total = this.stream()
                .reduce(0,(accum, transaction) -> accum + transaction.getAmount(), (x,y) ->x+y);

        for(int i = this.size()-1; i >= 0; i-- ){
            Transaction t = this.get(i);
            String line = transactionFormatter.format(t, total);
            console.println(line);
            total = total - t.getAmount();
        }
    }


}
