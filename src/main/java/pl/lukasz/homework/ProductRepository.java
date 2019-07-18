package pl.lukasz.homework;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public class ProductRepository {

    private LinkedList<Product> products;

    public ProductRepository() {
        this.products = new LinkedList<>();
        products.add(new Product("Kawa", 6.0));
        products.add(new Product("Mleko", 3.0));
        products.add(new Product("Konserwa tusrystyczna", 5.0));
    }

    public LinkedList<Product> getProduct() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();

        }
        return totalPrice;
    }
}
