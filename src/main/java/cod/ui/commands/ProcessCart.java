package cod.ui.commands;

import cod.CookieOnDemand;
import cod.tcf.Customer;
import cod.tcf.Voucher;
import cod.ui.framework.Command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProcessCart extends Command<CookieOnDemand> {

	private Customer customer;
	private Date date;

	@Override
	public String identifier() { return "send"; }

	@Override
	public void load(List<String> args) {
		customer = system.getCustomers().findByFirstName(args.get(0)).get();
		date = getFormatedDate(args.get(1)+" "+ args.get(2));
	}

    private Date getFormatedDate(String stringDate){
        Date dateFormated = null;
        try{
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
            dateFormated = formatter.parse(stringDate);
        }catch(Exception e){};

        return dateFormated;
    }

	@Override
	public void execute() {
		system.process(customer);
		Voucher v = customer.getVoucher().get();
        v.setTakeaway_date(date);
		System.out.println("  " + v);
	}

	@Override
	public String describe() {
		return "Send the contents of the cart to the bakery (send CUSTOMER)";
	}
}
