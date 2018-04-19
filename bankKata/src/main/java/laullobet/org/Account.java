package laullobet.org;

public class Account {
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statmentPrinter;
    private final Clock clock;

    public Account(TransactionRepository transactionRepository, StatementPrinter statmentPrinter, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.statmentPrinter = statmentPrinter;
        this.clock = clock;
    }

    public void deposit(int amount) {
        transactionRepository.store(new Transaction(amount,clock.now()));
    }

    public void withdraw(int amount) {
        transactionRepository.store(new Transaction(-amount, clock.now()));
    }

    public void printStatements() {
        statmentPrinter.addAll(transactionRepository.getAll());
        statmentPrinter.print();
    }
}
