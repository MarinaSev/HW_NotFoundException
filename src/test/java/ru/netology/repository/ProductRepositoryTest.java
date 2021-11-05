package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
  private ProductRepository repo = new ProductRepository();
  private Book first = new Book(12, "Тёмные аллеи", 400, "Иван Бунин", 213, 2010);
  private Book second = new Book(28, "Убить пересмешника", 530, "Харпер Ли", 418, 1998);

  @BeforeEach
  public void setUp() {
    repo.save(first);
    repo.save(second);
  }

  @Test
  public void shouldRemoveById() {
    repo.removeById(28);

    Product[] excpected = {first};
    Product[] actual = repo.findAll();

    assertArrayEquals(excpected, actual);
  }

  @Test
  public void shouldRemoveByFictialId() {

    assertThrows(NotFoundException.class, () -> {
      repo.removeById(48);
    });

  }

}
