/**
 * Created by Alex on 29.04.2016.
 */
public interface Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);
    abstract int getFrequentRenterPoints(int daysRented);
}
