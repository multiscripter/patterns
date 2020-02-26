package multiscripter.patterns.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Легковес (Flyweight) - структурный шаблон проектирования.
 * Решает задачу рационального использования памяти
 * за счёт вынесения общих неизменяемых свойств объектов в отдельный класс.
 */

/**
 * Пример:
 * Моделирование леса на миллион деревьев.
 * Дано:
 * Класс дерева.
 * Задача:
 * Разработать приложение, рационально использующее память.
 */

public class FlyweightTest {

  @Test
  public void showFlyweightUsage() {
    TreeModel model = TreeModelFactory.getTreeModel("big-tree");
    Tree[] trees = new Tree[1_000_000];
    for (int a = 0; a < trees.length; a++) {
      trees[a] = new Tree(a, model, 0, 0);
    }
    for (Tree tree : trees) {
      assertEquals(tree.getModel(), model);
    }
  }
}
