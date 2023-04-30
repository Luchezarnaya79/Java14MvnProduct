package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProduct {


    @Test

    public void testWhenFindIdRemoved() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(3, "Книга", 250);
        Product product3 = new Product(5, "Кастрюля", 3_000);
        Product product4 = new Product(7, "Ножи", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testWhenNotFindIdRemoved() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(3, "Книга", 250);
        Product product3 = new Product(5, "Кастрюля", 3_000);
        Product product4 = new Product(7, "Ножи", 5_000);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(2)
        );
    }


}
