package laullobet.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    @Test
    public void
    store_transactions() {
        TransactionRepository transactionRepository = new TransactionRepository();

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Transaction t1 = new Transaction(1,"1");
        Transaction t2 = new Transaction(2,"2");
        Transaction t3 = new Transaction(3,"3");
        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);

        transactionRepository.store(t1);//command
        transactionRepository.store(t2);
        transactionRepository.store(t3);

        assertEquals(transactionRepository.getAll(),transactions);//query
    }
}
