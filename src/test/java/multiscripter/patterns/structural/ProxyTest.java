package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Заместитель (Proxy) - структурный шаблон проектирования.
 * Решает задачу контроля доступа к некоторому объекту через объект-заместитель.
 */

/**
 * Пример:
 * Кеш запросов к базе данных.
 * Дано:
 * База данных.
 * Задача:
 * Разработать класс-заместитель для кеширования запросов к базе данных и результатов.
 */

public class ProxyTest {

  @Test
  public void showProxyUsage() {
    DBCache dbCache = new DBCache(new DB());
    String query = "select * from DB";
    String hash = Integer.toString(query.hashCode());
    String expected = "Берём из базы: " + hash;
    assertEquals(expected, dbCache.query(query));
    expected = "Берём из кеша: " + hash;
    assertEquals(expected, dbCache.query(query));
  }
}
