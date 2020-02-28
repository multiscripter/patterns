package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Посетитель (visitor) - поведенческий шаблон проектирования.
 * Решает задачу добавления функционала без изменения класса.
 */

/**
 * Пример.
 * Вычисление периметра и площади геометрических фигур.
 * Дано:
 * Классы геометрических фигур: квадрат и круг.
 * Задача:
 * Реализовать возможность вычисления периметра и площади.
 */

public class VisitorTest {

  @Test
  public void showVisitorUsage() {
    double side = 10;
    Square square = new Square(side);
    double radius = 5;
    Circle circle = new Circle(radius);

    Perimeter perimeter = new Perimeter();
    Area area = new Area();

    double squarePerimeter = square.accept(perimeter);
    double circlePerimeter = circle.accept(perimeter);
    double squareArea = square.accept(area);
    double circleArea = circle.accept(area);

    assertEquals(side * 4, squarePerimeter);
    assertEquals(2 * Math.PI * radius, circlePerimeter);
    assertEquals(side * side, squareArea);
    assertEquals((Math.PI * radius) * (Math.PI * radius), circleArea);
  }
}
