package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Адаптер (Adapter) - структурный шаблон проектирования.
 * Решает задачу унифицированный работы с классами,
 * имеющими несовместимый интерфейс.
 */

/**
 * Пример.
 * Дано:
 * 2 класса для отрисовки графики с несовместимыми интерфейсами.
 * Задача:
 * Разработать систему с унифицированным интерфейсом для работы с этими классами.
 */
public class AdapterTest {

    /**
     * Демонстрация применения шаблона Адаптер (Adapter).
     */
    @Test
    public void showAdapterUsage() {
        IRenderer driver;

        // Включаем драйвер Direct3D.
        driver = new Direct3DAdapter();
        String Direct3DActual = driver.render(960, 540);

        // Переключаем драйвер на OpenGL.
        driver = new OpenGLAdapter();
        String OpenGLActual = driver.render(960, 540);

        assertEquals("Direct3D.Pixel{x: 960, y: 540}", Direct3DActual);
        assertEquals("OpenGL.Pixel{x: 960, y: 540}", OpenGLActual);
    }
}
