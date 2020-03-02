package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Шаблонный метод (Template method) - поведенческий шаблон проектирования.
 * Решает задачу вариативности некоторого алгоритма через наследование.
 */

/**
 * Пример.
 * Демострация работы разработчиков разной квалификации.
 * Дано:
 * Абстрактный класс Разработчик и его конкретные реализации-наследники.
 * Задача:
 * Показать различия в работе разработчиков разной квалификации.
 */

public class TemplateMethodTest {

  private Task task;

  private String[] stages;

  @BeforeEach
  public void beforeTest() {
    String taskId = "TaskId-01";
    this.task = new Task(taskId);
    this.stages = new String[3];
    this.stages[0] = "Got task " + taskId + System.lineSeparator();
    this.stages[2] = "Task " + taskId + " completed.";
  }

  @Test
  public void showTemplateMethodUsageWithJunior() {
    String stage2 = "Searching for task solution in Google, asking older developers.";
    stage2 += System.lineSeparator();
    this.stages[1] = stage2;

    JuniorDeveloper junior = new JuniorDeveloper();
    String actual = junior.work(this.task);

    assertEquals(String.join("", this.stages), actual);
  }

  @Test
  public void showTemplateMethodUsageWithMiddle() {
    String stage2 = "Just doing task.";
    stage2 += System.lineSeparator();
    this.stages[1] = stage2;

    MiddleDeveloper junior = new MiddleDeveloper();
    String actual = junior.work(this.task);

    assertEquals(String.join("", this.stages), actual);
  }

  @Test
  public void showTemplateMethodUsageWithSenior() {
    String stage2 = "Delegating task to junior developer.";
    stage2 += System.lineSeparator();
    this.stages[1] = stage2;

    SeniorDeveloper junior = new SeniorDeveloper();
    String actual = junior.work(this.task);

    assertEquals(String.join("", this.stages), actual);
  }
}
