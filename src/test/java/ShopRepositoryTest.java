import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qa.NotFoundException;
import ru.netology.qa.Product;
import ru.netology.qa.ShopRepository;

public class ShopRepositoryTest {
    @Test
    public void removeProductWhatNotExist() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(55, "хлеб", 100);
        Product product2 = new Product(100, "вода", 50);
        Product product3 = new Product(155, "книга", 500);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(3)
        );
    }

    @Test
    public void removeProductWhatExist() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(12, "рис", 60);
        Product product2 = new Product(15, "сок", 40);
        Product product3 = new Product(90, "игрушка", 200);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(12);
        Product[] actual = repository.findAll();
        Product[] expected = {product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }
}


