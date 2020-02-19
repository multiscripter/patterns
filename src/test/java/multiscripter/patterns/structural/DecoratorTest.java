package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Декоратор (Decorator) — структурный шаблон проектирования.
 * Решает задачу динамического добавления дополнительного поведения к объекту.
 * Избавляет систему от необходимости реализовывать классы со всеми вариантами
 * функциональности.
 */

/**
 * Пример:
 * Оконная библиотека.
 * Дано:
 * Класс окна.
 * Задача:
 * Разработать систему с разными вариантами окна: с вертикальным скроллом,
 * с горизональным скроллом, с обеими скроллами.
 */

public class DecoratorTest {

  @Test
  public void showDecoratorUsage() {
    IDrawable window = new Window();
    assertEquals("I am window", window.draw());
    window = new HScrollWindow(window);
    assertEquals("I am window with HScroll", window.draw());
    window = new VScrollWindow(window);
    assertEquals("I am window with HScroll with VScroll", window.draw());
  }
}
