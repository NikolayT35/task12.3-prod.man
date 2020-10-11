package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Book firstBook = new Book(1, "One", 100, "King");
    Book secondBook = new Book(2, "Rock", 500, "Keysi");
    Book thirdBook = new Book(3, "Space", 1000, "Nokia");

    SmartPhone firstSmartPhone = new SmartPhone(1, "One", 100, "Honor");
    SmartPhone secondSmartPhone = new SmartPhone(5, "Rock", 500, "Samsung");
    SmartPhone thirdSmartPhone = new SmartPhone(6, "Space", 1000, "Nokia");

    @Test
    void shouldFindByNameIfExists() {
        ProductRepository repository = new ProductRepository();
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(firstSmartPhone);
        repository.save(secondSmartPhone);
        repository.save(thirdSmartPhone);

        ProductManager manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("One");
        Product[] expected = new Product[]{
                firstBook, firstSmartPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByProducerIfExists() {
        ProductRepository repository = new ProductRepository();
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(firstSmartPhone);
        repository.save(secondSmartPhone);
        repository.save(thirdSmartPhone);

        ProductManager manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{
                thirdBook, thirdSmartPhone};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindByAuthorIfExists() {
        ProductRepository repository = new ProductRepository();
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(firstSmartPhone);
        repository.save(secondSmartPhone);
        repository.save(thirdSmartPhone);

        ProductManager manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("King");
        Product[] expected = new Product[]{
                firstBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfExists() {
        ProductRepository repository = new ProductRepository();
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(firstSmartPhone);
        repository.save(secondSmartPhone);
        repository.save(thirdSmartPhone);

        ProductManager manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{
                secondSmartPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfNotExists() {
        ProductRepository repository = new ProductRepository();
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(firstSmartPhone);
        repository.save(secondSmartPhone);
        repository.save(thirdSmartPhone);

        ProductManager manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("Sky");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }
}