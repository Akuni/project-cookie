package cod.tcf;

import java.util.ArrayList;

/**
 * Created by user on 04/01/16.
 */
public class Shop {

    private ArrayList<Voucher> vouchers;

    public Shop(){
        vouchers = new ArrayList<>();
    }

    public void addVoucher(Voucher v){
        vouchers.add(v);
    }
}
