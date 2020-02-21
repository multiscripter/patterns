package multiscripter.patterns.structural;

import java.util.HashMap;

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

/**
 * Общий интерфейс.
 */
interface IDB {

  String query(String query);
}

/**
 * База дыннах (реальный объект).
 */
class DB implements IDB {

  @Override
  public String query(String query) {
    return Integer.toString(query.hashCode());
  }
}

/**
 * Кеш запросов (объект-заместитель).
 */
class DBCache implements IDB {

  private HashMap<String, String> cache;

  private DB db;

  public DBCache(DB db) {
    this.db = db;
    this.cache = new HashMap<>();
  }

  @Override
  public String query(String query) {
    return this.cache.containsKey(query)
        ? "Берём из кеша: " + this.cache.get(query)
        : "Берём из базы: " + this.cache(query);
  }

  private String cache(String query) {
    this.cache.put(query, this.db.query(query));
    return this.cache.get(query);
  }
}
