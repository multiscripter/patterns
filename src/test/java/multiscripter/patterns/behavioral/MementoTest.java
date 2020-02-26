package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Хранитель (Memento) - поведенческий шаблон проектирования.
 * Решает задачу сохранения и восстановления состояния системы.
 */

/**
 * Пример.
 * Восстановление состояния системы кнекоторому состоянию в прошлом.
 * Дано:
 * Системы со списком строк.
 * Задача:
 * Разработать систему восстановления состояния списка строк.
 */

public class MementoTest {

  @Test
  public void showMementoUsage() {
    SnapshotKeeper keeper = new SnapshotKeeper();
    StringList app = new StringList();

    app.addString("First string.");
    app.addString("Second string.");
    keeper.setShot(app.saveState());
    app.addString("Third string.");
    app.restoreState(keeper.getShot());
    assertEquals(keeper.getShot().getState(), app.getStrings());
  }
}
