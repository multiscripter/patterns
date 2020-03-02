package multiscripter.patterns.behavioral;

/**
 * Шаблонный метод (Template method) - поведенческий шаблон проектирования.
 * Решает задачу вариативности некоторого алгоритма через наследование.
 */

abstract class AbstractDeveloper {
  protected Task task;

  public String getTask(Task task) {
    this.task = task;
    return String.format("Got task %s", this.task.getId());
  }

  public String doTask() {
    return "Just doing task.";
  }

  public String reportTask() {
    return String.format("Task %s completed.", this.task.getId());
  }

  public String work(Task task) {
    StringBuilder flow = new StringBuilder();
    flow.append(this.getTask(task));
    flow.append(System.lineSeparator());
    flow.append(this.doTask());
    flow.append(System.lineSeparator());
    flow.append(this.reportTask());
    return flow.toString();
  }
}

class JuniorDeveloper extends AbstractDeveloper {
  public String doTask() {
    return "Searching for task solution in Google, asking older developers.";
  }
}

class MiddleDeveloper extends AbstractDeveloper {
}

class SeniorDeveloper extends AbstractDeveloper {
  public String doTask() {
    return "Delegating task to junior developer.";
  }
}

class Task {
  private String id;

  public Task(String id) {
    this.id = id;
  }
  public String getId() {
    return this.id;
  }
}
