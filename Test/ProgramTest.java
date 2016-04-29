import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
/**
 * Created by Alex on 29.04.2016.
 */
public class ProgramTest {
    @Test
    public void main() throws Exception {
        Movie m1 = new Movie("video1", 1);
        assertThat(m1.getTitle(), is("video1"));
        assertThat(m1.getPriceCode(), is(1));

        Movie m2 = new Movie("video2", 2);
        assertThat(m2.getTitle(), is("video2"));
        assertThat(m2.getPriceCode(), is(2));

        Rental r1 = new Rental(m1, 10);
        assertThat(r1.getMovie(), equalTo(m1));
        assertThat(r1.getDaysRented(), is(10));

        Rental r2 = new Rental(m2, 5);
        assertThat(r2.getMovie(), equalTo(m2));
        assertThat(r2.getDaysRented(), is(5));

        Customer c1 = new Customer("jan");
        assertThat(c1.getName(), is("jan"));
        c1.addRental(r1);   c1.addRental(r2);

        String str= "Rental Record for jan\n";
        str+="\tTitle\t\tDays\tAmount\n";
        str+="\tvideo1\t\t10\t30.0\n";
        str+="\tvideo2\t\t5\t4.5\n";
        str+="Amount owed is 34.5\n";
        str+="You earned 3 frequent renter points";

        assertThat(c1.statement(),is (str));

    }

}