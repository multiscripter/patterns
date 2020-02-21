package multiscripter.patterns.behavioral;

import java.util.Stack;

/**
 * Команда (Command) - поведенческий шаблон проектирования.
 * Решает задачу уменьшения связанности системы за счёт выделения действий
 * в отдельную абстракцию.
 */

/**
 * Пример.
 * Эмуляторы консоли и ядра. Инструкция, введённая в консоли, передаётся ядру
 * на выполнение в объекте команды.
 * Поддерживает просмотр истории введённых инструкций как назад так и вперёд.
 */

/**
 * Общий интерфейс комманд.
 */
abstract class Command {

  protected Core core;

  public Command(Core core) {
    this.core = core;
  }

  abstract String execute();
}

/**
 * Выполнить команду.
 * ConcreteCommand.
 */
class PerformCommand extends Command {

  private String instruction;

  public PerformCommand(Core core, String instruction) {
    super(core);
    this.instruction = instruction;
  }

  @Override
  public String execute() {
    return this.core.perform(this.instruction);
  }
}

/**
 * Следующая команда.
 * ConcreteCommand.
 */
class NextCommand extends Command {

  public NextCommand(Core core) {
    super(core);
  }

  @Override
  public String execute() {
    return this.core.getNextCommand();
  }
}

/**
 * Предыдущая команда.
 * ConcreteCommand.
 */
class PrevCommand extends Command {

  public PrevCommand(Core core) {
    super(core);
  }

  @Override
  public String execute() {
    return this.core.getPrevCommand();
  }
}

/**
 * Ядро, исполняющее команды.
 * Бизнес-слой.
 * Receiver.
 */
class Core {

  private Stack<String> history;
  private int index;
  private int total;

  public Core() {
    this.history = new Stack<>();
    this.index = -1;
    this.total = 0;
  }

  public String perform(String instruction) {
    if (this.index < this.total - 1) {
      Stack<String> s = new Stack<>();
      s.addAll(this.history.subList(0, this.index + 1));
      this.history = s;
      this.total = this.index + 1;
    }
    this.history.push(instruction);
    this.index++;
    this.total++;
    return "Performing: " + instruction;
  }

  public String getNextCommand() {
    return this.index + 1 < this.total ? "Returning: " + this.history.get(++this.index) : "";
  }

  public String getPrevCommand() {
    return this.index > -1 ? "Returning: " + this.history.get(this.index--) : "";
  }
}

/**
 * Консоль.
 * Пользовательский интерфейс.
 * Invoker.
 */
class Console {

  private Core core;

  public Console(Core core) {
    this.core = core;
  }

  /**
   * Ввести инструкцию.
   * @param instruction новая инструкция.
   * @return Результат выполення инструкции.
   */
  public String enter(String instruction) {
    return new PerformCommand(this.core, instruction).execute();
  }

  /**
   * Вывести пердыдущую инструкцию.
   * @return пердыдущая инструкцию.
   */
  public String arrowUp() {
    return new PrevCommand(this.core).execute();
  }

  /**
   * Вывести следующую инструкцию.
   * @return следующая инструкция.
   */
  public String arrowDown() {
    return new NextCommand(this.core).execute();
  }
}
