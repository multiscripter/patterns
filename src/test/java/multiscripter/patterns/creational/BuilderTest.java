package multiscripter.patterns.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Строитель (Builder) - порождающий шаблон проектирования.
 * Решает задачу размножения конструкторов с разными параметрами.
 */

/**
 * Пример.
 * Комплектация машины опциями.
 * Задача:
 * Разработать систему комплектации машины опциями.
 */

public class BuilderTest {

  @Test
  public void showBuilderUsage() {
    EquipDirector director = new EquipDirector();

    director.setBuilder(new BaseEquipBuilder());
    director.equip();
    Car cheapCar = director.getCar();
    assertTrue(cheapCar.isIzoGlass());
    assertFalse(cheapCar.issWCover());
    assertFalse(cheapCar.isMedia());

    director.setBuilder(new BizEquipBuilder());
    director.equip();
    Car avgCar = director.getCar();
    assertTrue(avgCar.isIzoGlass());
    assertTrue(avgCar.issWCover());
    assertFalse(avgCar.isMedia());

    director.setBuilder(new LuxEquipBuilder());
    director.equip();
    Car expensiveCar = director.getCar();
    assertTrue(expensiveCar.isIzoGlass());
    assertTrue(expensiveCar.issWCover());
    assertTrue(expensiveCar.isMedia());
  }
}
