package multiscripter.patterns.structural;

import java.util.HashMap;

/**
 * Легковес (Flyweight) - структурный шаблон проектирования.
 * Решает задачу рационального использования памяти
 * за счёт вынесения общих неизменяемых свойств объектов в отдельный класс.
 */

/**
 * Пример:
 * Моделирование леса на миллион деревьев.
 * Дано:
 * Класс дерева.
 * Задача:
 * Разработать приложение, рационально использующее память.
 */

/**
 * Модель дерева.
 * Содержит общие для всех деревьев неизменяемые свойства.
 */
class TreeModel {
  // Модель дерева (весит 100 Кб.).
  private final String model;

  private final String name;

  public TreeModel(String model, String name) {
    this.model = model;
    this.name = name;
  }

  public String getModel() {
    return this.model;
  }

  public String getName() {
    return this.name;
  }
}

/**
 * Фабрика моделей деревьев.
 */
class TreeModelFactory {

  private static HashMap<String, TreeModel> trees = new HashMap<>();

  public static TreeModel getTreeModel(String name) {
    if (!trees.containsKey(name)) {
      trees.put(name, new TreeModel(name + "-model", name));
    }
    return trees.get(name);
  }
}

/**
 * Конкретное дерево.
 */
class Tree {

  private int id;

  private TreeModel model;

  private int rotate = 0;

  private int x;

  private int y;

  public Tree(int id, TreeModel model, int x, int y) {
    this.id = id;
    this.model = model;
    this.x = x;
    this.y = y;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public TreeModel getModel() {
    return this.model;
  }

  public void setModel(TreeModel model) {
    this.model = model;
  }

  public int getRotate() {
    return this.rotate;
  }

  public void setRotate(int rotate) {
    this.rotate = rotate;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }
}
