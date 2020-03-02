package multiscripter.patterns.creational;

/**
 * Прототип (Prototype) - порождающий шаблон проектирования.
 * Решает задачу создания независимой копии объекта с некоторым состоянием
 * без вызова конструкторов.
 */

abstract class Shape {
  protected int x;
  protected int y;

  /**
   * Конструктор по умолчанию. Нужен для Rectangle.class.newInstance().
   */
  public Shape() {
  }

  public Shape(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}

class Rectangle extends Shape {
  private int height;
  private int width;

  /**
   * Конструктор по умолчанию. Нужен для Rectangle.class.newInstance().
   */
  public Rectangle() {
  }

  public Rectangle(int x, int y, int height, int width) {
    super(x, y);
    this.height = height;
    this.width = width;
  }

  public Rectangle clone() {
    Rectangle copy = null;
    try {
      copy = Rectangle.class.newInstance();
      copy.x = this.x;
      copy.y = this.y;
      copy.height = this.height;
      copy.width = this.width;
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return copy;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }
}
