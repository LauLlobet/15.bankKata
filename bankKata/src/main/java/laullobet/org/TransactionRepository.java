package laullobet.org;

import java.util.ArrayList;

public class TransactionRepository {

    private ArrayList<Transaction> storage = new ArrayList<>();

    public void store(Transaction transaction) {
        storage.add(transaction);
    }

    public ArrayList<Transaction> getAll() {
        return storage;
    }
}
