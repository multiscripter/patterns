package multiscripter.patterns.structural;

/**
 * Декоратор (Decorator) — структурный шаблон проектирования.
 * Решает задачу динамического добавления дополнительного поведения классу.
 * Избавляет систему от необходимости реализовывать классы со всеми вариантами
 * функциональности.
 */

/**
 * Пример:
 * Оконная библиотека.
 * Дано:
 * Класс окна.
 * Задача:
 * Разработать систему с разными вариантами окна: с вертикальным скроллом,
 * с горизональным скроллом, с обеими скроллами.
 */

interface IDrawable {
  String draw();
}

class Window implements IDrawable {

  @Override
  public String draw() {
    return "I am window";
  }
}

/**
 * Абстрактное окно со скроллом.
 * Базовый декоратор.
 */
abstract class ScrollWindow extends Window {

  protected IDrawable window;

  public ScrollWindow(IDrawable window) {
    this.window = window;
  }
}

/**
 * Окно с горизонтальным скроллом.
 * Первый вариант декоратора.
 */
class HScrollWindow extends ScrollWindow implements IDrawable {

  public HScrollWindow(IDrawable window) {
    super(window);
  }

  @Override
  public String draw() {
    return this.window.draw() + " with HScroll";
  }
}

/**
 * Окно с вертикальным скроллом.
 * Второй вариант декоратора.
 */
class VScrollWindow extends ScrollWindow implements IDrawable {

  public VScrollWindow(IDrawable window) {
    super(window);
  }

  @Override
  public String draw() {
    return this.window.draw() + " with VScroll";
  }
}
