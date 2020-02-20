package multiscripter.patterns.behavioral;

/**
 * Итератор (Iterator) - поведенческий шаблон проектирования.
 * Решает задачу последовательного доступа к элементам объекта-агрегата.
 */

/**
 * Пример.
 * Итератор по массивам обобщённых типов.
 */

interface IIterator<E> {
  boolean hasNext();
  E next();
  E remove();
}

class ArrayIterator<E> implements IIterator<E> {

  private E[] items;

  private int pos = -1;

  private int size = 0;

  public ArrayIterator(E[] collection) {
    this.items = collection;
    this.size = collection.length;
  }

  @Override
  public boolean hasNext() {
    return this.pos + 1 < this.size;
  }

  @Override
  public E next() {
    return this.items[++this.pos];
  }

  @Override
  public E remove() {
    if (this.pos < 0) {
      throw new IllegalStateException("Call next() before call remove()");
    }
    E removed = this.items[this.pos];
    System.arraycopy(this.items, this.pos + 1, this.items, this.pos, this.size - this.pos - 1);
    this.size--;
    this.pos--;
    return removed;
  }
}
