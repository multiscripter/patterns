package multiscripter.patterns.behavioral;

import java.util.ArrayList;

/**
 * Хранитель (Memento) - поведенческий шаблон проектирования.
 * Решает задачу сохранения и восстановления состояния системы.
 */

/**
 * Пример.
 * Восстановление состояния системы кнекоторому состоянию в прошлом.
 * Дано:
 * Системы со списком строк.
 * Задача:
 * Разработать систему восстановления состояния списка строк.
 */

/**
 * Снимок состояния системы (Memento).
 */
class Snapshot {

  private final ArrayList<String> strings;

  public Snapshot(ArrayList<String> strings) {
    this.strings = strings;
  }

  public ArrayList<String> getState() {
    return this.strings;
  }
}

/**
 * Хранитель снимка состояния системы (Caretaker).
 */
class SnapshotKeeper {

  private Snapshot shot;

  public Snapshot getShot() {
    return this.shot;
  }

  public void setShot(Snapshot shot) {
    this.shot = shot;
  }
}

/**
 * Система, чьё состояние необходимо сохранять и восстанавливать (Originator).
 */
class StringList {

  private ArrayList<String> strings;

  public StringList() {
    this.strings = new ArrayList<>();
  }

  public void addString(String str) {
    this.strings.add(str);
  }

  public ArrayList<String> getStrings() {
    return this.strings;
  }

  /**
   * Сохраняет состояние системы в незавимисую копию.
   * @return снимок состояния системы.
   */
  public Snapshot saveState() {
    ArrayList<String> shot = new ArrayList<>();
    for (String str : this.strings) {
      shot.add(str.intern());
    }
    return new Snapshot(shot);
  }

  public void restoreState(Snapshot shot) {
    this.strings = shot.getState();
  }
}
