package cod.ui.commands;

import cod.CookieOnDemand;
import cod.ShoppingCart;
import cod.tcf.Customer;
import cod.tcf.Voucher;
import cod.ui.framework.Command;

import java.util.*;

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
        List<Voucher> v = new ArrayList<>();
        for(Customer customer : system.getCustomers().getAll()){
            v.add(customer.getVoucher().get());
        }
        Collections.sort(v);
        System.out.println("=====================");
        for(Voucher vx : v){
            System.out.println(vx);
        }
        System.out.println("=====================");
    }

    @Override
    public String describe() {
        return "List all commands";
    }
}
