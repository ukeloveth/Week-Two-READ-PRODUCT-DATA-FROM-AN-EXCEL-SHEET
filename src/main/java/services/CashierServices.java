package services;

import models.Customer;
import models.Staff;
import models.Store;
import servicesImpl.CashierServicesImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CashierServices {
    void fetchProductFromStore(Staff staff, Store store, String filename) throws IOException;
    void printReceipt(Integer customerId, Store store);
}
