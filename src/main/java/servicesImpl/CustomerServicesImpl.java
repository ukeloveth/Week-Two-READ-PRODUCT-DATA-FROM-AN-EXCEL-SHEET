package servicesImpl;

import models.Customer;
import models.Product;
import models.Store;
import services.CustomerServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CustomerServicesImpl implements CustomerServices {
    @Override
    public void addProductToCart(Customer customer, Store store, int id) {
        Map<Product,Integer> cartItems = this.getCart();
        List<Product> productList = new ArrayList<>(cartItems.keySet());
        if(store.getProductList().contains(product) && productList.contains(product)){
            for (Product item: productList){
                if(Objects.equals(item.getName(), product.getName())){
                    Integer currentQuantity = cartItems.get(product);
                    cartItems.put(product,currentQuantity+quantity);
                    System.out.println("Product added");
                }

            }
        }else{
            cartItems.put(product,quantity);
            System.out.println("Product added");
        }
    }

    @Override
    public void removeProductFromCart() {

    }

    @Override
    public void checkout() {

    }
}
