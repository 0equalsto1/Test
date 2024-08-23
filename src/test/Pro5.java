package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pro5 {
    static List<Product> emptyList = new ArrayList<>();
    static String productInfoApi = "";

    public static void main(String[] args) {
        ProductInfoService service = new ProductInfoService();
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int max = sc.nextInt();
        int offset = 0;
        while (offset <= max) {

            List<Product> products = service.getProducts(offset, limit);
            service.saveProducts(products);
            offset = offset + limit;
        }
    }

    static class ProductInfoService {
        public List<Product> getProducts(int offset, int limit) {
            try {
                List<Product> products = new ArrayList<>();// api call
                return products;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return emptyList;
            }
        }

        public boolean saveProducts(List<Product> products) {
            try {
                //save prodcts to DB
                return true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }

        }
    }

    static class Product {
        int id;
        String category;
        String name;
        double price;

        public Product(int id, String category, String name, double price) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
