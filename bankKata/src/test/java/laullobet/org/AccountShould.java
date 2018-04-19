package laullobet.org;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {


    public static final String DATE = "30-10-1986";
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private StatementPrinter statmentPrinter;

    private Account account;

    @Mock
    private Clock clock;

    @Before
    public void set_up(){
        account = new Account(transactionRepository, statmentPrinter, clock);
    }

    @Test
    public void
    store_deposit() {

        when(clock.now()).thenReturn(DATE); // STUB
        account.deposit(100); // COMMAND

        verify(transactionRepository).store(new Transaction(100, DATE)); //MOCK
    }

    @Test
    public void
    store_withdrawal() {

        when(clock.now()).thenReturn(DATE);
        account.withdraw(100);

        verify(transactionRepository).store(new Transaction(-100, DATE));
    }


}
