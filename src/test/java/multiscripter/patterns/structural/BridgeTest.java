package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Мост (Bridge) - структурный шаблон проектирования.
 * Решает задачу унифицированного управления классов, реализующих один интерфейс,
 * классами, реализующими другой интерфейс.
 *
 * Применяется в случаях, когда нужно, чтобы любая реализация управляющего
 * интерфейса могла управлять любой реализацией управляемого интерфейса.
 */
public class BridgeTest {

  /**
   * Демонстрация применения шаблона Мост (Bridge).
   * 2 разных управляющих объекта: AIControl и ProgramControl.
   * 2 разных управляемых объекта: Car и Ship.
   */
  @Test
  public void showBridgeUsage() {

    Car car = new Car();

    AIControl ai = new AIControl(car);
    ai.decision("front-slow");
    assertEquals("front", car.getDirection());
    assertEquals(10, car.getSpeed());
    assertEquals("I am Car controlled by AIControl", ai.getStatus());

    ProgramControl pro = new ProgramControl(car);
    pro.sequence(new String[] {"current", "back"}, new int[] {0, 5});
    assertEquals("back", car.getDirection());
    assertEquals(5, car.getSpeed());
    assertEquals("I am Car controlled by ProgramControl", pro.getStatus());

    assertEquals("I am rolling in direction: back with speed: 5", pro.getTransportAction());

    Ship ship = new Ship();

    ai = new AIControl(ship);
    ai.decision("front-slow");
    assertEquals("front", ship.getDirection());
    assertEquals(10, ship.getSpeed());
    assertEquals("I am Ship controlled by AIControl", ai.getStatus());

    pro = new ProgramControl(ship);
    pro.sequence(new String[] {"current", "back"}, new int[] {0, 15});
    assertEquals("back", ship.getDirection());
    assertEquals(15, ship.getSpeed());
    assertEquals("I am Ship controlled by ProgramControl", pro.getStatus());

    assertEquals("I am swimming in direction: back with speed: 15", pro.getTransportAction());
  }
}
