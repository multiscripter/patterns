package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Состояние (англ. State) - поведенческий шаблон проектирования.
 * Решает задачу изменения поведения объекта в зависимости от состояния.
 */

/**
 * Пример.
 * Светофор.
 * Дано:
 * Светофор (контекст) и три цвета (состояния).
 * Задача:
 * Разработать механизм автоматического переключения цвета светофора по циклической схеме:
 * Красный -> Жёлтый -> Зелёный -> Жёлтый -> (повтор).
 */
public class StateTest {

  @Test
  public void showStateUsage() {
    TrafficLight trafficLight = new TrafficLight(new LightRed());
    assertEquals(TLights.RED.name(), trafficLight.getLight());
    trafficLight.turnLight();
    assertEquals(TLights.YELLOW.name(), trafficLight.getLight());
    trafficLight.turnLight();
    assertEquals(TLights.GREEN.name(), trafficLight.getLight());
    trafficLight.turnLight();
    assertEquals(TLights.YELLOW.name(), trafficLight.getLight());
    trafficLight.turnLight();
    assertEquals(TLights.RED.name(), trafficLight.getLight());
    trafficLight.turnLight();
    assertEquals(TLights.YELLOW.name(), trafficLight.getLight());
  }
}
