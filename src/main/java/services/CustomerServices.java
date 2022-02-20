package services;

import models.Customer;
import models.Store;

public interface CustomerServices {
    void addProductToCart(Customer customer, Store store, int id);
    void removeProductFromCart();
    void checkout();
}
