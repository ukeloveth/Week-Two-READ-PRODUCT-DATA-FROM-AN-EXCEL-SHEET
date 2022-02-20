package servicesImpl;

import enums.Gender;
import enums.Role;
import models.Staff;
import models.Store;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CashierServicesImplTest {
    Store store1;
    Staff staff1;
    CashierServicesImpl cashierServicesImpl;
    @Before
    public void setUp() throws Exception {
        store1 = new Store();
        staff1 =  new Staff(1,"johnny", Gender.MALE,"johnny@live.com","DEC-JAV-1", Role.CASHIER,"BSC",70);
        cashierServicesImpl = new CashierServicesImpl();
    }

    @Test
    public void fetchProductFromStore() throws IOException {
        cashierServicesImpl.fetchProductFromStore(staff1,store1,"productData.xlsx");
        assertEquals(1,store1.getProductList()[0].getId());
        //assertNotNull(store1.getProductList());
    }

    @Test
    public void validatePurchase() {
    }

    @Test
    public void printReceipt() {
    }
}