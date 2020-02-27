package multiscripter.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Наблюдатель (Observer) - поведенческий шаблон проектирования.
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

/**
 * Интерфейс наблюдателя.
 */
interface Observer {
  /**
   * Обрабатывает сообщение, посылаемое наблюдаемым при событии изменения состояния.
   * @param message сообщение.
   */
  void handleEvent(String message);
}

/**
 * Интерфейс наблюдаемого.
 * При изменении своего состояния он извещает об этом событии наблюдателей.
 */
interface Observable {
  void registerObserver(Observer client);
  void removeObserver(Observer client);
  void notifyObservers();
}

/**
 * Рассылатель новостей (Наблюдаемый (Observable)).
 */
class NewsSender implements Observable {

  private String news;

  private List<Observer> clients = new ArrayList<>();

  public void registerObserver(Observer client) {
    this.clients.add(client);
  }

  public void removeObserver(Observer client) {
    this.clients.remove(client);
  }

  /**
   * Уведомить подписчиков, послав им новость.
   */
  public void notifyObservers() {
    this.clients.forEach(client -> client.handleEvent(this.news));
  }

  public void setNews(String news) {
    this.news = news;
    this.notifyObservers();
  }
}

/**
 * Клиент, подписавшийся на рассылку новостей.
 */
class NewsClient implements Observer {

  private String news;

  /**
   * Обрабатывает сообщение с новостью, пришедшее от Рассылателя новостей.
   * @param message сообщение.
   */
  public void handleEvent(String message) {
    this.news = message;
  }

  public String getNews() {
    return this.news;
  }
}
