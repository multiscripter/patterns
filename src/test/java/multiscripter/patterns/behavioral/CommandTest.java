package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Команда (Command) - поведенческий шаблон проектирования.
 * Решает задачу уменьшения связанности системы за счёт выделения действий
 * в отдельную абстракцию.
 */

/**
 * Пример.
 * Эмуляторы консоли и ядра. Инструкция, введённая в консоли, передаётся ядру
 * на выполнение в объекте команды.
 * Поддерживает просмотр истории введённых инструкций как назад так и вперёд.
 */

/**
 * Выплняет роль Client в UML-схеме.
 */
public class CommandTest {

  @Test
  public void showCommandUsage() {
    Core core = new Core();
    Console console = new Console(core);
    assertEquals("Performing: whoami", console.enter("whoami"));
    assertEquals("Performing: pwd", console.enter("pwd"));
    assertEquals("Performing: ls -al", console.enter("ls -al"));
    assertEquals("Returning: ls -al", console.arrowUp());
    assertEquals("Returning: pwd", console.arrowUp());
    assertEquals("Returning: whoami", console.arrowUp());
    assertEquals("", console.arrowUp());
    assertEquals("Performing: cd /", console.enter("cd /"));
    assertEquals("Returning: cd /", console.arrowUp());
    assertEquals("", console.arrowUp());
    assertEquals("Returning: cd /", console.arrowDown());
    assertEquals("", console.arrowDown());
  }
}
