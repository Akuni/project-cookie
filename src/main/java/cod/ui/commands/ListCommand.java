package cod.ui.commands;

import cod.CookieOnDemand;
import cod.CustomerDatabase;
import cod.ShoppingCart;
import cod.tcf.Customer;
import cod.tcf.Voucher;
import cod.ui.framework.Command;

/**
 * Created by SARROCHE Nicolas on 04/01/16.
 */
public class ListCommand extends Command<CookieOnDemand> {
    @Override
    public String identifier() {
        return "list";
    }

    @Override
    public void execute() {
        CustomerDatabase db = system.getCustomers();
        for(Customer customer : system.getCustomers().getAll()){
            System.out.println( customer.getFirstName() + " : " + customer.getVoucher());
        }
        System.out.println("----------");
        for(Customer c : system.getCustomers().getAll()){
            ShoppingCart cart = system.getShoppingCart(c);
            if (cart.contents().isEmpty()){
                System.out.println(c.getFirstName() + " :  Empty cart");
            } else {
                System.out.println(c.getFirstName() + " :  " + cart.contents());
            }
        }
        System.out.println("----------");
    }

    @Override
    public String describe() {
        return "List all commands";
    }
}
