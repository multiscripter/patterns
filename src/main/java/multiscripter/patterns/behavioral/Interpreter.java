package multiscripter.patterns.behavioral;

import java.util.HashMap;

/**
 * Интерпретатор (Interpreter) — поведенческий шаблон проектирования.
 * Решает однотипные задачи, которые можно описать лексическим языком.
 */

class Context {
  private HashMap<String, Integer> variables;

  public Context() {
    this.variables = new HashMap<>();
  }

  public int getVariable(String name) {
    return this.variables.get(name);
  }

  public void setVariable(String name, int value) {
    this.variables.put(name, value);
  }
}

/**
 * Интерфейс интерпретатора.
 */
interface IExpression {
  int interpret(Context context);
}

/**
 * Терминальное выражение.
 */
class NumberExpression implements IExpression {

  private String name;

  public NumberExpression(String variableName) {
    name = variableName;
  }

  public int interpret(Context context) {
    return context.getVariable(name);
  }
}

/**
 * Нетерминальное выражение для сложения.
 */
class AddExpression implements IExpression {

  private IExpression leftExpression;
  private IExpression rightExpression;

  public AddExpression(IExpression left, IExpression right) {
    leftExpression = left;
    rightExpression = right;
  }

  public int interpret(Context context) {
    return leftExpression.interpret(context) + rightExpression.interpret(context);
  }
}

/**
 * Нетерминальное выражение для вычитания.
 */
class SubtractExpression implements IExpression {

  private IExpression leftExpression;
  private IExpression rightExpression;

  public SubtractExpression(IExpression left, IExpression right) {
    leftExpression = left;
    rightExpression = right;
  }

  public int interpret(Context context) {
    return leftExpression.interpret(context) - rightExpression.interpret(context);
  }
}
