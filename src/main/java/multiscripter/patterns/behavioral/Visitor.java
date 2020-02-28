package multiscripter.patterns.behavioral;

/**
 * Посетитель (visitor) - поведенческий шаблон проектирования.
 * Решает задачу добавления функционала без изменения класса.
 */

/**
 * Интерфейс действия (посетителя).
 */
interface IVisitor {
  double visit(Square square);
  double visit(Circle circle);
}

/**
 * Интерфейс элемента (посещаемого).
 */
interface IVisitable {
  double accept(IVisitor visitor);
}

/**
 * Квадрат (Element A).
 */
class Square implements IVisitable {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  public double accept (IVisitor visitor) {
    return visitor.visit(this);
  }

  public double getSide() {
    return this.side;
  }
}

/**
 * Квадрат (Element B).
 */
class Circle implements IVisitable {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double accept (IVisitor visitor) {
    return visitor.visit(this);
  }

  public double getRadius() {
    return this.radius;
  }
}

/**
 * Периметр (ConcreteVisitor1).
 */
class Perimeter implements IVisitor {

  @Override
  public double visit(Square square) {
    return square.getSide() * 4;
  }

  @Override
  public double visit(Circle circle) {
    return 2 * Math.PI * circle.getRadius();
  }
}

/**
 * Площадь (ConcreteVisitor2).
 */
class Area implements IVisitor {

  @Override
  public double visit(Square square) {
    return Math.pow(square.getSide(), 2);
  }

  @Override
  public double visit(Circle circle) {
    return Math.pow(circle.getRadius() * Math.PI, 2);
  }
}
