package pl.beutysite.recruit.orders;

import pl.beutysite.recruit.OrderFlag;
import pl.beutysite.recruit.TaxCalculationsHelper;

import java.math.BigDecimal;
import java.util.regex.Pattern;


/**
 * Created by Neo on 24.02.2017.
 */
public class CombineOrder extends Order {
    private  BigDecimal tax;
    private  BigDecimal price;
    public CombineOrder(int itemId, int customerId, BigDecimal price,OrderFlag... flags) {
        super(itemId, customerId, price);
        this.tax=new BigDecimal(0);
        this.price=price;
        for (OrderFlag f :
                flags) {
            switch (f) {
                case STANDARD: {
                    tax= getTax().add(TaxCalculationsHelper.getPercentagePart(super.getPrice(), new BigDecimal("23.5")));
                    break;
                }
                case PRIORITY: {
                    this.price = getPrice().add(TaxCalculationsHelper.getPercentagePart(super.getPrice(), new BigDecimal("1.5")));
                    break;
                }
                case INTERNATIONAL: {
                    tax= TaxCalculationsHelper.add(getTax(),(TaxCalculationsHelper.getPercentagePart(super.getPrice(), new BigDecimal("15"))));
                    break;
                }
                case DISCOUNTED: {
                    this.price = TaxCalculationsHelper.subtractPercentage(super.getPrice(), new BigDecimal("11"));
                    System.out.println(this.price+" eqwe");
                }
                if (tax.equals(BigDecimal.ZERO)) {
                    tax=TaxCalculationsHelper.getPercentagePart(super.getPrice(), new BigDecimal("23.5"));
                }
            }
        }
    }

    @Override
    public BigDecimal getTotalAmount() {

        return TaxCalculationsHelper.add(getPrice(),getTax());
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public BigDecimal getTax() {
        return tax;
    }
}
