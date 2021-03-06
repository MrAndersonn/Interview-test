package pl.beutysite.recruit;

import pl.beutysite.recruit.orders.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class OrdersManagementSystemImpl implements OrdersManagementSystem {

    //external systems
    private final TaxOfficeAdapter taxOfficeAdapter;
    private final ItemsRepository itemsRepository;


    private Set<Order> ordersQueue=new HashSet<Order>();
    private Order newOrder=null;

    public OrdersManagementSystemImpl(TaxOfficeAdapter taxOfficeAdapter, ItemsRepository itemsRepository) {
        this.taxOfficeAdapter = taxOfficeAdapter;
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void createOrder(int itemId, int customerId, OrderFlag... flags) {
        boolean isPriority=false;
        //fetch price and calculate discount and taxes
        BigDecimal itemPrice = itemsRepository.fetchItemPrice(itemId);
        System.out.println(itemPrice);
        //create and queue order
        for (OrderFlag f :
                flags) {
            if (f==OrderFlag.PRIORITY)
                isPriority=true;
        }
        OrderFlag flag= null;
        if (flags.length==1) {
            flag = flags[0];
            switch (flag) {
                case STANDARD: newOrder=new Order(itemId,customerId,itemPrice); break;
                case PRIORITY: newOrder=new PriorityOrder(itemId,customerId,itemPrice); break;
                case INTERNATIONAL: newOrder=new InternationalOrder(itemId,customerId,itemPrice); break;
                case DISCOUNTED: newOrder=new DiscountedOrder(itemId,customerId,itemPrice); break;
            }
        }else newOrder= new CombineOrder(itemId,customerId,itemPrice,flags);

        ordersQueue.add(newOrder);

        //JIRA-18883 Fix priority orders not always being fetched first
        if (isPriority) {
            while (fetchNextOrder()!=newOrder) {
                ordersQueue.remove(newOrder);
                newOrder=new CombineOrder(itemId,customerId,itemPrice,flags);
                ordersQueue.add(newOrder);
            }
            ordersQueue.add(newOrder);
        }

        //send tax due amount
        taxOfficeAdapter.registerTax(newOrder.getTax());
    }

    @Override
    public Order fetchNextOrder() {
        return ordersQueue.iterator().next();
    }
}
