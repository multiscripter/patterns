package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Цепочка обязанностей (Chain of responsibility) - поведенческий шаблон проектирования.
 * Решает задачу обработки сообщений компонентами в системе с уровнями ответственности.
 * Сообщения в системе обрабатываются по схеме "обработай сам либо перешли другому".
 */

/**
 * Пример.
 * Дано:
 * Центр поддержки клиентов состоящий из трёх отделов:
 * 1. Нейросеть. Отвечает на сообщения из списка. Иначе передаёт сообщение дальше.
 * 2. Общий отдел. Оператор отвечает на сообщения общего характера. Иначе передаёт сообщение дальше.
 * 3. Технический отдел. Технический специалист отвечает на сообщения технического характера.
 * Задача:
 * Разработать систему автоматизированного распределения сообщений в зависимости
 * от их типа по отделам центра поддержки клиентов.
 */
public class ChainOfResponsibilityTest {

  @Test
  public void showChainOfResponsibilityUsage() {
    Support support1 = new Support(Support.Levels.NEURAL);
    Support support2 = new Support(Support.Levels.COMMON);
    Support support3 = new Support(Support.Levels.TECH);
    support2.setNext(support3);
    support1.setNext(support2);

    String actual = support1.handleMessage("for neural network support", Support.Levels.NEURAL);
    assertEquals(actual,  "message handled by " + Support.Levels.NEURAL.name());

    actual = support1.handleMessage("for common support", Support.Levels.COMMON);
    assertEquals(actual,  "message handled by " + Support.Levels.COMMON.name());

    actual = support1.handleMessage("for tech support", Support.Levels.TECH);
    assertEquals(actual,  "message handled by " + Support.Levels.TECH.name());
  }
}
