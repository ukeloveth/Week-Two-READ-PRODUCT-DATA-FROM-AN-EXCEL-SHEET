package services;

import models.Staff;
import models.Store;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CashierServices {
    void fetchProductFromStore(Staff staff, Store store, String filename) throws IOException;
    void validatePurchase();
    void printReceipt();
}
