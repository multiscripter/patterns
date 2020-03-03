package multiscripter.patterns.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Абстрактная фабрика (Abstract factory) - порождающий шаблон проектирования.
 * Решает задачу разработки взаимозаменяемых интерфейсов создания объектов.
 */

/**
 * Пример.
 * Платформонезависимая система создания оконных элементов.
 */

public class AbstractFactoryTest {

  @Test
  public void showAbstractFactoryUsage() {
    String expected = "";
    Application app;
    IGUIFactory factory;
    String osName = System.getProperty("os.name").toLowerCase();
    expected += String.format("You created %s button.%s", osName, System.lineSeparator());
    expected += String.format("You created %s checkbox.%s", osName, System.lineSeparator());
    if ("linux".equals(osName)) {
      factory = new LinuxFactory();
    } else {
      factory = new WindowsFactory();
    }
    app = new Application(factory);
    String actual = app.paint();

    assertEquals(expected, actual);
  }
}
