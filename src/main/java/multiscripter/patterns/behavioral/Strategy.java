package multiscripter.patterns.behavioral;

/**
 * Стратегия (Strategy) - поведенческий шаблон проектирования.
 * Решает задачу взаимозаменяемости классов с одинаковым интерфейсом.
 */

/**
 * Пример.
 * Дано:
 * Несколько систем логирования (логирование на файла, логирование в БД).
 * Задача:
 * Разработать систему с возможностью в нужный момент использовать нужную
 * систему логирования.
 */

/**
 * Интерфейс логирования.
 * Класс, реализующий конкретную стратегию, должен реализовывать этот интерфейс.
 * Класс контекста использует этот интерфейс для вызова конкретной стратегии.
 */
interface ILogger {

    String log(String message);
}

/**
 * Логгер на файлах. Конкретная реализация.
 */
class FileLogger implements ILogger {

    public String log(String message) {
        return "I am file logger. " + message;
    }
}

/**
 * Логгер в БД. Конкретная реализация.
 */
class DBLogger implements ILogger {

    public String log(String message) {
        return "I am database logger. " + message;
    }
}

/**
 * Класс контекста, использующий интерфейс стратегии.
 */
class Logger {
    private ILogger logger;

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public String writeToLog(String message) {
        return this.logger.log(message);
    }
}
