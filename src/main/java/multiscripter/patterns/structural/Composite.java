package multiscripter.patterns.structural;

import java.util.HashMap;

/**
 * Компоновщик (Composite) — структурный шаблон проектирования.
 * Решает задачу единого взаимодействия как с простыми,
 * так и с составными (содержащими коллекцию простых) компонентами системы через
 * унифицированный интерфейс. Объединяет объекты в древовидную структуру
 * для представления иерархии от частного к целому.
 */

/**
 * Пример.
 * Дано:
 * Сеть из компьютеров (древовидная структура), которая состоит из простых
 * компонентов - компьютеров (листьев дерева (Leaf))
 * и составных компонетов - серверов (узлов дерева (Composite)).
 * Компонент имеет собстенную нагрузку = 1.
 * Задача:
 * Разработать систему с возможностью получать суммарную нагрузку компонента.
 */

/**
 * Общий интерфейс для всех компонентов.
 * Component.
 */
interface INet {

  String getId();

  /**
   * Возвращает нагрузку элемента сети (Server или Host).
   * @return нагрузка элемента сети.
   */
  int getLoad();
}

/**
 * Компьютер в сети.
 * Leaf (Простой компонент).
 */
class Host implements INet {

  protected String id;

  public Host(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public int getLoad() {
    return 1;
  }
}

/**
 * Сервер с подключёнными к нему компьютерами в сети.
 * Composite (Составной компонент).
 */
class Server extends Host {

  HashMap<String, INet> nodes = new HashMap<>();

  public Server(String id) {
    super(id);
  }

  public void addNode(INet node) {
    this.nodes.put(node.getId(), node);
  }

  public int getLoad() {
    return this.nodes.values().stream().mapToInt(INet::getLoad).sum() + 1;
  }
}
