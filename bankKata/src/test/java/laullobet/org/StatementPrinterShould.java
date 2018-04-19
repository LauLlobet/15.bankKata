package laullobet.org;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    public static final String STATEMENT_HEADER_LINE = "date || credit || debit || balance";

    @Mock
    Console console;
    @Mock
    private TransactionFormatter transactionFormatter;

    private StatementPrinter statementPrinter;
    private ArrayList<Transaction> transactions;

    @Before
    public void set_up() {
        statementPrinter = new StatementPrinter(console, transactionFormatter);
        transactions = new ArrayList();
    }

    @Test
    public void
    print_header_only_when_transactions_are_empty() {
        statementPrinter.print();

        verify(console).println(STATEMENT_HEADER_LINE);
    }

    @Test
    public void
    print_two_transactions(){

        statementPrinter.add(new Transaction(500, "14/01/2012"));
        statementPrinter.add(new Transaction(-20,"15/01/2012"));

        String firstTransactionLine = "14/01/2012 || || 500.00 || 500.00";
        String secondTransactionLine = "15/01/2012 || 20.00 || || 480.00";

        when(transactionFormatter.format(new Transaction(500, "14/01/2012"), 500))
                .thenReturn(firstTransactionLine);
        when(transactionFormatter.format(new Transaction(-20,"15/01/2012"),480))
                .thenReturn(secondTransactionLine);

        statementPrinter.print();//command


        InOrder inOrder = inOrder(console);
        inOrder.verify(console).println(STATEMENT_HEADER_LINE);
        inOrder.verify(console).println(secondTransactionLine);
        inOrder.verify(console).println(firstTransactionLine);

    }

}
