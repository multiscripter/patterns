package multiscripter.patterns.behavioral;

/**
 * Цепочка обязанностей (Chain of responsibility) - поведенческий шаблон проектирования.
 * Решает задачу обработки сообщений компонентами в системе с разделением обязанностей.
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
class Support {

  public enum Levels {
    NEURAL, COMMON, TECH
  }

  private Support.Levels level;

  private Support support;

  public Support(Support.Levels level) {
    this.level = level;
  }

  public void setNext(Support support) {
    this.support = support;
  }

  public String handleMessage(String message, Support.Levels level) {
    return level.ordinal() > this.level.ordinal() && this.support != null
        ? this.support.handleMessage(message, level)
        : "message handled by " + this.level.name();
  }
}
