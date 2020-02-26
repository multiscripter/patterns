package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Наблюдатель (Observer) — поведенческий шаблон проектирования.
 * Так же известен как "Издатель-подписчик" (publisher-subscriber или pub/sub).
 * Решает задачу изменения состояния одного или нескольких объектов (наблюдателей),
 * в зависимости от состояния другого объекта (наблюдаемого).
 */

/**
 * Пример.
 * Дано:
 * Новости. Клиенты, нуждающиеся в новостях.
 * Задача:
 * Разработать систему рассылки новостей клиентам.
 */
public class ObserverTest {

  @Test
  public void showObserverUsage() {
    NewsSender publisher = new NewsSender();
    List<NewsClient> subscribers = new ArrayList<>();
    for (int a = 0; a < 5; a++) {
      NewsClient subscriber = new NewsClient();
      subscribers.add(subscriber);
      publisher.registerObserver(subscriber);
    }
    String lastNews = "";
    for (int a = 0; a < 5; a++) {
      lastNews = "test news " + a;
      publisher.setNews(lastNews);
    }
    for (NewsClient subscriber : subscribers) {
      assertEquals(lastNews, subscriber.getNews());
    }
  }
}
