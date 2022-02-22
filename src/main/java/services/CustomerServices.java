package services;

import models.Customer;
import models.Staff;
import models.Store;
import servicesImpl.CashierServicesImpl;

public interface CustomerServices {
    void addProductToCart(Customer customer, Store store, int id,int quantity);
    void removeProductFromCart();
    boolean checkout(Customer customer, CashierServicesImpl cashierServicesImpl, Store store);
}
