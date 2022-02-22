package servicesImpl;

import exceptions.CartIsEmptyException;
import exceptions.ProductDoesNotExist;
import exceptions.PurchaseCouldNotBeValidatedException;
import exceptions.QuantityIsGreaterException;
import models.*;
import services.CustomerServices;

import java.time.LocalDateTime;
import java.util.*;

public class CustomerServicesImpl implements CustomerServices {
    @Override
    public void addProductToCart(Customer customer, Store store, int id, int quantity) {
        Map<Product,Integer> cartItems = customer.getCart();
        Product[] productListFromCart = cartItems.keySet().toArray(new Product[0]);
        Product[] productListFromStore = store.getProductList();
        Product foundProductInStore = null;
        for (Product product : productListFromStore) {
            if (product.getId() == id) {
                foundProductInStore = product;
                break;
            }
        }
        if (foundProductInStore == null){
            throw new ProductDoesNotExist("Product does not exist or is out of stock");
        }
        Product foundProductInCart = null;
        for (Product product : productListFromCart) {
            if (product.getId() == id) {
                foundProductInCart = product;
                break;
            }
        }
        if (foundProductInCart != null){
            if (quantity <= foundProductInStore.getQuantity()){
                cartItems.put(foundProductInCart,foundProductInCart.getQuantity() + quantity);
            }else {
                throw new QuantityIsGreaterException("Quantity you are trying to add is greater than quantity in store");
            }
        }
        if(!cartItems.isEmpty() && cartItems.containsKey(foundProductInStore)){
            if (quantity <= foundProductInStore.getQuantity()){
                int initialQuantity = cartItems.get(foundProductInStore);
                int newQuantity = initialQuantity + quantity;
                if (!(newQuantity >= foundProductInStore.getQuantity())){
                    cartItems.put(foundProductInStore,newQuantity);
                }else{
                    throw new QuantityIsGreaterException("Quantity you want to add is greater than quantity in store");
                }
            }
        }
        cartItems.put(foundProductInStore,quantity);
    }

    @Override
    public void removeProductFromCart() {

    }

    @Override
    public boolean checkout(Customer customer, CashierServicesImpl cashierServicesImpl, Store store) {
        Map<Product,Integer> cartItems = customer.getCart();
        if (cartItems.isEmpty()) {
            throw new CartIsEmptyException("Cart is empty");
        }
        double totalPrice = 0.00;
        for (Map.Entry<Product,Integer> item : cartItems.entrySet()){
            totalPrice += item.getKey().getPrice() * item.getValue();
        }
        if (!(customer.getWallet() >= totalPrice)){
            throw new PurchaseCouldNotBeValidatedException("Purchase could not be validated, please check your balance and try again");
        }
        store.setAccount(store.getAccount() + totalPrice);
        customer.setWallet(customer.getWallet() - totalPrice);
        for (Product gadget : store.getProductList()) {
            if (cartItems.containsKey(gadget)){
                int initialQuantity = cartItems.get(gadget);
                gadget.setQuantity(initialQuantity - gadget.getQuantity());
            }
        }
        cartItems.clear();
        Map<Integer,List<TransactionData>> transactionData = store.getTransactionHistory();

        if (transactionData.get(customer.getId()) != null){
            List<TransactionData> listOfTransactions = transactionData.get(customer.getId());
            TransactionData transaction = new TransactionData(customer.getName(), LocalDateTime.now(),totalPrice);
            listOfTransactions.add(transaction);
            transactionData.put(customer.getId(),listOfTransactions);
            store.setTransactionHistory(transactionData);
        }

        return true;
    }
}
