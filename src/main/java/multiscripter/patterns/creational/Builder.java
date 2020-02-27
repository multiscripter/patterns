package multiscripter.patterns.creational;

/**
 * Строитель (Builder) - порождающий шаблон проектирования.
 * Решает задачу размножения конструкторов с разными параметрами.
 */

/**
 * Продукт (Product).
 */
class Car {
  /**
   * Изотермические стёкла.
   */
  boolean izoGlass;

  /**
   * Чехол запасного колеса.
   */
  boolean sWCover;

  /**
   * Мультимедийная система.
   */
  boolean media;

  public boolean isIzoGlass() {
    return this.izoGlass;
  }

  public void setIzoGlass(boolean izoGlass) {
    this.izoGlass = izoGlass;
  }

  public boolean issWCover() {
    return this.sWCover;
  }

  public void setsWCover(boolean sWCover) {
    this.sWCover = sWCover;
  }

  public boolean isMedia() {
    return this.media;
  }

  public void setMedia(boolean media) {
    this.media = media;
  }
}

/**
 * Общий интерсейс Builder.
 */
interface IEquipBuilder {
  void setIzoGlass();
  void setSWCover();
  void setMMedia();
  void setCar();
  Car getCar();
}

/**
 * Комплектация Базовая (Concrete builder).
 */
class BaseEquipBuilder implements IEquipBuilder {

  private Car car;

  public void setCar() {
    this.car = new Car();
  }

  @Override
  public void setIzoGlass() {
    this.car.setIzoGlass(true);
  }

  @Override
  public void setSWCover() {
  }

  @Override
  public void setMMedia() {
  }

  @Override
  public Car getCar() {
    return this.car;
  }
}

/**
 * Комплектация Бизнесс (Concrete builder).
 */
class BizEquipBuilder implements IEquipBuilder {

  private Car car;

  public void setCar() {
    this.car = new Car();
  }

  @Override
  public void setIzoGlass() {
    this.car.setIzoGlass(true);
  }

  @Override
  public void setSWCover() {
    this.car.setsWCover(true);
  }

  @Override
  public void setMMedia() {
  }

  @Override
  public Car getCar() {
    return this.car;
  }
}

/**
 * Комплектация Люкс (Concrete builder).
 */
class LuxEquipBuilder implements IEquipBuilder {

  private Car car;

  public void setCar() {
    this.car = new Car();
  }

  @Override
  public void setIzoGlass() {
    this.car.setIzoGlass(true);
  }

  @Override
  public void setSWCover() {
    this.car.setsWCover(true);
  }

  @Override
  public void setMMedia() {
    this.car.setMedia(true);
  }

  @Override
  public Car getCar() {
    return this.car;
  }
}

/**
 * Комплектует машину конкретной комплектацией (Director).
 */
class EquipDirector {

  private IEquipBuilder builder;

  public void setBuilder(IEquipBuilder builder) {
    this.builder = builder;
  }

  public void equip() {
    this.builder.setCar();
    this.builder.setIzoGlass();
    this.builder.setSWCover();
    this.builder.setMMedia();
  }

  public Car getCar() {
    return this.builder.getCar();
  }
}
