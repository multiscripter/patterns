package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Итератор (Iterator) - поведенческий шаблон проектирования.
 * Решает задачу последовательного доступа к элементам объекта-агрегата.
 */

/**
 * Пример.
 * Итератор по массивам обобщённых типов.
 */
public class IteratorTest {

  @Test
  public void showIteratorUsage() {

    Integer[] arr = new Integer[3];
    Integer[] expected = new Integer[arr.length];
    for (int a = 0; a < arr.length; a++) {
      arr[a] = a;
      expected[a] = a;
    }

    ArrayIterator<Integer> iter = new ArrayIterator<>(arr);
    int a = 0;
    while (iter.hasNext()) {
      assertEquals(expected[a++], iter.next());
    }

    a = 0;
    iter = new ArrayIterator<>(arr);
    while (iter.hasNext()) {
      iter.next();
      Integer removed = iter.remove();
      assertEquals(expected[a++], removed);
    }
  }
}
