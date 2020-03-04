package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Интерпретатор (Interpreter) — поведенческий шаблон проектирования.
 * Решает однотипные задачи, которые можно описать лексическим языком.
 */

/**
 * Пример.
 * Вычислитель арфметических выражений.
 * Задача:
 * Разработать интерпретатор и вычислитель арфметических выражений.
 */

public class InterpreterTest {

  @Test
  public void showInterpreterUsage() {
    Context context = new Context();

    // определяем набор переменных
    int x = 5;
    int y = 8;
    int z = 2;

    // добавляем переменные в контекст
    context.setVariable("x", x);
    context.setVariable("y", y);
    context.setVariable("z", z);

    // создаем объект для вычисления выражения x + y - z
    IExpression expression = new SubtractExpression(
        new AddExpression(
            new NumberExpression("x"), new NumberExpression("y")
        ),
        new NumberExpression("z")
    );

    int actual = expression.interpret(context);
    assertEquals(11, actual);
  }
}
