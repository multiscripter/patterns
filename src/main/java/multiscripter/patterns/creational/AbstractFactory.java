package multiscripter.patterns.creational;

/**
 * Абстрактная фабрика (Abstract factory) - порождающий шаблон проектирования.
 * Решает задачу разработки взаимозаменяемых интерфейсов создания объектов.
 */

/**
 * AbstractProductA.
 */
interface IButton {
  String paint();
}

/**
 * ConcreteProductA1.
 */
class LinuxButton implements IButton {
  @Override
  public String paint() {
    return "You created linux button.";
  }
}

/**
 * ConcreteProductA2.
 */
class WindowsButton implements IButton {
  @Override
  public String paint() {
    return "You created windows button.";
  }
}

/**
 * AbstractProductB.
 */
interface ICheckbox {
  String paint();
}

/**
 * ConcreteProductB1.
 */
class LinuxCheckbox implements ICheckbox {
  @Override
  public String paint() {
    return "You created linux checkbox.";
  }
}

/**
 * ConcreteProductB2.
 */
class WindowsCheckbox implements ICheckbox {
  @Override
  public String paint() {
    return "You created windows checkbox.";
  }
}

/**
 * AbstractFactory.
 */
interface IGUIFactory {
  IButton createButton();
  ICheckbox createCheckbox();
}

/**
 * ConcreteFactory1.
 */
class LinuxFactory implements IGUIFactory {
  @Override
  public IButton createButton() {
    return new LinuxButton();
  }

  @Override
  public ICheckbox createCheckbox() {
    return new LinuxCheckbox();
  }
}

/**
 * ConcreteFactory2.
 */
class WindowsFactory implements IGUIFactory {

  @Override
  public IButton createButton() {
    return new WindowsButton();
  }

  @Override
  public ICheckbox createCheckbox() {
    return new WindowsCheckbox();
  }
}

/**
 * Client.
 */
class Application {
  private IButton button;
  private ICheckbox checkbox;

  public Application(IGUIFactory factory) {
    button = factory.createButton();
    checkbox = factory.createCheckbox();
  }

  public String paint() {
    String result = "";
    result += button.paint();
    result += System.lineSeparator();
    result += checkbox.paint();
    result += System.lineSeparator();
    return result;
  }
}
