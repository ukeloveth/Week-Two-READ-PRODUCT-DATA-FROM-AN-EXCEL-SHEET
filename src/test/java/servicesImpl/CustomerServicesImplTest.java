package servicesImpl;

import enums.Gender;
import enums.Role;
import models.Customer;
import models.Product;
import models.Staff;
import models.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerServicesImplTest {
    Store store1;
    CashierServicesImpl cashierServicesImpl;
    CustomerServicesImpl customerServicesImpl;
    Staff staff1;
    Customer customer1;
    Product product1;
    @Before
    public void setUp() throws Exception {
        store1 = new Store();

        staff1 =  new Staff(1,"johnny", Gender.MALE,"johnny@live.com","DEC-JAV-1", Role.CASHIER,"BSC",70);
        customerServicesImpl = new CustomerServicesImpl();
        cashierServicesImpl = new CashierServicesImpl();
        customer1 = new Customer(2,"dennis",Gender.MALE,"dennis@live.com");
        cashierServicesImpl.fetchProductFromStore(staff1,store1,"productData.xlsx");
    }

    @Test
    public void addProductToCart() {
        customerServicesImpl.addProductToCart(customer1,store1,store1.getProductList()[1].getId());
        assertEquals(1,customer1.getCart().size());
    }

    @Test
    public void removeProductFromCart() {
    }

    @Test
    public void checkout() {
    }
}