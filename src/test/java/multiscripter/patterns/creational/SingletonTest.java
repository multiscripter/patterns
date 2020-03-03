package multiscripter.patterns.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Одиночка (Singleton) - порождающий шаблон проектирования.
 * Решает задачу существования в системе единственного экземпляра некоторого класса.
 */

public class SingletonTest {

  @Test
  public void showSingletonUsage() {
    // 1. Eager initialization.
    EagerInitializedSingleton eis1 = EagerInitializedSingleton.getInstance();
    EagerInitializedSingleton eis2 = EagerInitializedSingleton.getInstance();
    assertEquals(eis1, eis2);

    // 2. Static block initialization.
    StaticBlockSingleton sbs1 = StaticBlockSingleton.getInstance();
    StaticBlockSingleton sbs2 = StaticBlockSingleton.getInstance();
    assertEquals(sbs1, sbs2);

    // 3. Lazy Initialization.
    LazyInitializedSingleton lis1 = LazyInitializedSingleton.getInstance();
    LazyInitializedSingleton lis2 = LazyInitializedSingleton.getInstance();
    assertEquals(lis1, lis2);

    // 4. Lazy Initialization Thread Safe Singleton (double checked locking).
    ThreadSafeSingleton tss1 = ThreadSafeSingleton.getInstance();
    ThreadSafeSingleton tss2 = ThreadSafeSingleton.getInstance();
    assertEquals(tss1, tss2);

    // 5. Bill Pugh Singleton Implementation (inner class instance holder).
    BillPughSingleton bpn1 = BillPughSingleton.getInstance();
    BillPughSingleton bpn2 = BillPughSingleton.getInstance();
    assertEquals(bpn1, bpn2);

    // 6. Enum Singleton (Joshua Bloch`s best way).
    EnumSingleton es1 = EnumSingleton.INSTANCE;
    EnumSingleton es2 = EnumSingleton.INSTANCE;
    assertEquals(es1, es2);
  }
}
