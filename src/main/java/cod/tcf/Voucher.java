package cod.tcf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * A voucher should be presented at the bakery to pick up the order.
 */
public class Voucher {

	// An unique identifier for this voucher
	private String uuid;
	// The ordered cookies.
	private List<Item> contents;
    // Date cookies
    private Date takeaway_date;

	public Voucher() {
		uuid = UUID.randomUUID().toString();
		contents = new LinkedList<>();
        takeaway_date = new Date();
	}

	public String getUuid() {
		return uuid;
	}
	public List<Item> getContents() {
		return contents;
	}
    public Date getTakeaway_date() {return takeaway_date;}

	public int numberOfCookies() {
		return contents.stream().map(it -> it.getQuantity()).reduce(0,(acc,n) -> acc + n);
	}

	@Override
	public String toString() {
		return "Voucher for "+ numberOfCookies()+" cookies { " +
				"ref: '" + uuid + '\'' +
				" -> " + contents +
                " takeaway date " + takeaway_date +
				" }";
	}

    // Adding new date
    public void setTakeaway_date(Date date){
        takeaway_date = date;
    }

}
