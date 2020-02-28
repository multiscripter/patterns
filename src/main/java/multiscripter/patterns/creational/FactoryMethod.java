package multiscripter.patterns.creational;

/**
 * Фабричный метод (Factory method) - порождающий шаблон проектирования.
 * Решает задачу неявного создания экземпляров классов на уровне интерфейсов.
 * Другое название: виртуальный конструктор (Virtual constructor).
 */

enum WarriorCat {
  Infantry, Airborne
}

/**
 * Интерфейс продукта (Product).
 */
interface IWarrior {
  String attack();
}

/**
 * Конкретный продукт (ConcreteProduct).
 */
class Infantry implements IWarrior {

  @Override
  public String attack() {
    return "Run and gun";
  }
}

/**
 * Конкретный продукт (ConcreteProduct).
 */
class Airborne implements  IWarrior {

  @Override
  public String attack() {
    return "Born and burn";
  }
}

/**
 * Интерфейс создавателя (Creator).
 */
interface IWarriorCreator {
  IWarrior create();
}

/**
 * Конкретный создаватель (ConcreteCreator).
 */
class InfantryCreator implements  IWarriorCreator {

  @Override
  public IWarrior create() {
    return new Infantry();
  }
}

/**
 * Конкретный создаватель (ConcreteCreator).
 */
class AirborneCreator implements  IWarriorCreator {

  @Override
  public IWarrior create() {
    return new Airborne();
  }
}
