package multiscripter.patterns.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Прототип (Prototype) - порождающий шаблон проектирования.
 * Решает задачу создания независимой копии объекта с некоторым состоянием
 * без вызова конструкторов.
 */

public class PrototypeTest {

  @Test
  public void showPrototypeUsage() {
    Rectangle rectOrig = new Rectangle(10, 15, 20, 25);
    Rectangle rectCopy = rectOrig.clone();

    // Удостовериться, что это не один и тот же объект.
    assertNotEquals(rectOrig, rectCopy);
    // Удостовериться, что значения всех полей одинаковые.
    assertTrue(rectOrig.getX() == rectCopy.getX()
        && rectOrig.getY() == rectCopy.getY()
        && rectOrig.getHeight() == rectCopy.getHeight()
        && rectOrig.getWidth() == rectCopy.getWidth());
  }
}
