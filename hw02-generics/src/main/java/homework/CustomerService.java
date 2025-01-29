package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {
  private final TreeMap<Customer, String> map;

  public CustomerService() {
    map = new TreeMap<>(Comparator.comparing(Customer::getScores));
  }

  public void add(Customer customer, String data) {
    map.put(customer, data);
  }

  public Map.Entry<Customer, String> getSmallest() {
    Map.Entry<Customer, String> entry = map.firstEntry();
    return createEntry(entry);
  }

  public Map.Entry<Customer, String> getNext(Customer customer) {
    Map.Entry<Customer, String> entry = map.higherEntry(customer);
    return createEntry(entry);
  }

  private Map.Entry<Customer, String> createEntry(Map.Entry<Customer, String> entry) {
    if (entry == null) {
      return null;
    }

    return new Map.Entry<>() {
      @Override
      public Customer getKey() {
        Customer value = entry.getKey();
        return new Customer(value.getId(), value.getName(), value.getScores());
      }

      @Override
      public String getValue() {
        return entry.getValue();
      }

      @Override
      public String setValue(String value) {
        return entry.setValue(value);
      }
    };
  }
}
