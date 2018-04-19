package laullobet.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Formatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TransactionFormatterShould {

    @Test
    public void
    format_a_deposit_to_string() {
        Transaction transaction = new Transaction(500,"14/01/2012");

        TransactionFormatter transactionFormatter = new TransactionFormatter();
        String formatedString = transactionFormatter.format(transaction, 2500); // COMMAND OR QUERY?

        assertThat(formatedString,is("14/01/2012 || 500.00 || || 2500.00"));
    }

    @Test
    public void
    format_a_withdrawal() {
        TransactionFormatter transactionFormatter = new TransactionFormatter();
        Transaction transaction = new Transaction(-20,"14/01/2012");

        String fomattedString = transactionFormatter.format(transaction, 2500);

        assertThat(fomattedString,is("14/01/2012 || || 20.00 || 2500.00"));
    }

}
