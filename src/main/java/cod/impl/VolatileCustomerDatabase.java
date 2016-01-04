package cod.impl;

import cod.CustomerDatabase;
import cod.tcf.*;

import java.util.*;

public class VolatileCustomerDatabase implements CustomerDatabase {

	private Set<Customer> customers = new HashSet<>();

	@Override
	public void add(Customer c) { customers.add(c); }

	@Override
	public Optional<Customer> findByFirstName(String firstName) {
		return customers
				.stream()
				.filter(c -> c.getFirstName().equals(firstName))
				.findFirst();
	}

	@Override
	public List<Customer> getAll(){
		List<Customer> res = new ArrayList<>();
		res.addAll(customers);
		return res;
	}

}
