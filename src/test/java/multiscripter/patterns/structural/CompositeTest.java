package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Компоновщик (Composite) — структурный шаблон проектирования.
 * Решает задачу унифицированного взаимодействия как с простыми,
 * так и с составными (содержащими коллекцию простых) компонентами системы через
 * единый интерфейс. Объединяет объекты в древовидную структуру
 * для представления иерархии от общего к частного.
 */

/**
 * Пример.
 * Дано:
 * Сеть из компьютеров (древовидная структура), которая состоит из простых
 * компонентов - компьютеров (листьев дерева (Leaf))
 * и составных компонетов - серверов (узлов дерева (Composite)).
 * Компонент имеет собстенную нагрузку = 1.
 * Задача:
 * Разработать систему с возможностью получать суммарную нагрузку компонента.
 */
public class CompositeTest {

  @Test
  public void showCompositeUsage() {
    Server s1 = new Server("Host-1");
    Server s2 = new Server("Host-2");
    Server s3 = new Server("Host-3");
    Server s4 = new Server("Host-4");

    s1.addNode(s2);
    s1.addNode(new Host("Host-5"));
    s1.addNode(s3);
    s2.addNode(new Host("Host-6"));
    s2.addNode(new Host("Host-7"));
    s3.addNode(s4);
    s3.addNode(new Host("Host-8"));
    s4.addNode(new Host("Host-9"));

    // Суммарная нагрузка всей сети.
    assertEquals(9, s1.getLoad());
    // Суммарная нагрузка конкретного составного компонента (сервера).
    assertEquals(3, s2.getLoad());
  }
}
