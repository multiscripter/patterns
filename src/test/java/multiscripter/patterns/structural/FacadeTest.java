package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Фасад (Facade) - структурный шаблон проектирования.
 * Решает задачу простого использования системы
 * через предоставление упрощённого интерфейса.
 */

/**
 * Пример:
 * Медиа конвертер.
 * Дано:
 * Класс конвертера и несколько классов аудио и видео кодеков.
 * Задача:
 * Разработать класс-фасад, позволяющий конвертировать без необходимости
 * указывать множество настроек кодеков.
 */

public class FacadeTest {

  @Test
  public void showFacadeUsage() {
    String expected = "File MyVideo {settings: Settings: {audio {name: MP3, "
        + "bitrate: 384}, video {name: MPEG4, width: 1920, height: 1080, bitrate: 5000}}}";
    LightConverter converter = new LightConverter("FullHD");
    String actual = converter.convert("MyVideo");
    assertEquals(expected, actual);
  }
}
