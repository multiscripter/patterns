package multiscripter.patterns.creational;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Фабричный метод (Factory method) - порождающий шаблон проектирования.
 * Решает задачу неявного создания экземпляров классов на уровне интерфейсов.
 * Другое название: виртуальный конструктор (Virtual constructor).
 */

/**
 * Пример.
 * Создание армии.
 * Дано:
 * Классы родов войск: пехота и ВДВ.
 * Задача:
 * Реализовать возможность неявного создания экземпляров.
 */

public class FactoryMethodTest {

  @Test
  public void showFactoryMethodUsage() {
    HashMap<WarriorCat, IWarriorCreator> creators = new HashMap<>();
    creators.put(WarriorCat.Infantry, new InfantryCreator());
    creators.put(WarriorCat.Airborne, new AirborneCreator());
    IWarrior infantry = creators.get(WarriorCat.Infantry).create();
    IWarrior airborne = creators.get(WarriorCat.Airborne).create();
    assertEquals("Run and gun", infantry.attack());
    assertEquals("Born and burn", airborne.attack());
  }
}
