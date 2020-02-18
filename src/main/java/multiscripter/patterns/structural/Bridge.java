package multiscripter.patterns.structural;

/**
 * Мост (Bridge) - структурный шаблон проектирования.
 * Решает задачу унифицированного управления классов, реализующих один интерфейс,
 * классами, реализующими другой интерфейс.
 *
 * Применяется в случаях, когда нужно, чтобы любая реализация управляющего
 * интерфейса могла управлять любой реализацией управляемого интерфейса.
 *
 * Решение о применении Моста принимается на стадии проектирования дизайна.
 */

/**
 * Пример.
 * Дано:
 * 2 несовместимых интерфейса управления и транспорта.
 * Задача:
 * Разработать систему, позволяющую любому классу с интерфейсом управления
 * управлять любым классом с интерфейсом транспорта.
 */

/**
 * Интерфейс, через который происходит управление управляемой сущностью
 * (Implementor).
 */
interface ITransport {

  String getAction();

  String getDirection();

  void setDirection(String direction);

  int getSpeed();

  void setSpeed(int speed);

  String getStatus();
}

abstract class Transport implements ITransport {

  protected String direction;

  protected int speed;

  public String getDirection() {
    return this.direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public String getStatus() {
    return "I am " + getClass().getSimpleName();
  }
}

/**
 * Конкретная имплементация (Управляемая сущность).
 * (Concrete Implementor).
 */
class Car extends Transport {

  public String getAction() {
    return String.format("I am rolling in direction: %s with speed: %d", this.direction, this.speed);
  }
}

/**
 * Конкретная имплементация (Управляемая сущность).
 * (Concrete Implementor).
 */
class Ship extends Transport {
  public String getAction() {
    return String.format("I am swimming in direction: %s with speed: %d", this.direction, this.speed);
  }
}

/**
 * Интерфейс управления (Abstraction).
 */
abstract class AbstractControl {

  protected ITransport transport;

  public void move(String direction, int speed) {
    this.transport.setDirection(direction);
    this.transport.setSpeed(speed);
  }

  public String getStatus() {
    return this.transport.getStatus() + " controlled by " + getClass().getSimpleName();
  }

  public String getTransportAction() {
    return this.transport.getAction();
  }
}

/**
 * Конкретаня имплементация (Управляющая сущность).
 * (Redefined Abstraction).
 */
class AIControl extends AbstractControl {

  public AIControl(ITransport transport) {
    this.transport = transport;
  }

  public void decision(String command) {
    if ("front-slow".equals(command)) {
      this.move("front", 10);
    } else if ("front-fast".equals(command)) {
      this.move("front", 100);
    } if ("stop".equals(command)) {
      this.move("current", 0);
    }
  }
}

/**
 * Конкретаня имплементация (Управляющая сущность).
 * (Redefined Abstraction).
 */
class ProgramControl extends AbstractControl {

  public ProgramControl(ITransport transport) {
    this.transport = transport;
  }

  public void sequence(String[] directions, int[] speeds) {
    for (int a = 0; a < directions.length; a++) {
      this.move(directions[a], speeds[a]);
    }
  }
}
