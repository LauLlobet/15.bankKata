package laullobet.org;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {
    @Mock
    private Console console;
    @Mock
    private Clock clock;

    @Test
    public void print_statements() {

        StatementPrinter statementPrinter = new StatementPrinter(console, new TransactionFormatter());
        TransactionRepository transactionRepository = new TransactionRepository();
        Account account = new Account(transactionRepository, statementPrinter, clock);

        when(clock.now()).thenReturn("10/01/2012")
                .thenReturn("13/01/2012")
                .thenReturn("14/01/2012");

        account.deposit(1000); // command
        account.deposit(2000);
        account.withdraw(500);

        account.printStatements(); // command

        InOrder inOrder = inOrder(console);

        inOrder.verify(console).println("date || credit || debit || balance");
        inOrder.verify(console).println("14/01/2012 || || 500.00 || 2500.00");
        inOrder.verify(console).println("13/01/2012 || 2000.00 || || 3000.00");
        inOrder.verify(console).println("10/01/2012 || 1000.00 || || 1000.00");
    }
    /*

    Given a client

     makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When she prints her bank statement
Then she would see
date || credit || debit || balance
14/01/2012 || || 500.00 || 2500.00
13/01/2012 || 2000.00 || || 3000.00
10/01/2012 || 1000.00 || || 1000.00
*/
}
