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
public class FinishedCommands extends Command<CookieOnDemand> {
    @Override
    public String identifier() {
        return "done";
    }

    @Override
    public void execute() {
        CustomerDatabase db = system.getCustomers();

        System.out.println("Your order is prepared");
    }

    @Override
    public String describe() {
        return "Finalise an order";
    }
}
