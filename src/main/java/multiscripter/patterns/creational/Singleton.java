package multiscripter.patterns.creational;

/**
 * Одиночка (Singleton) - порождающий шаблон проектирования.
 * Решает задачу существования в системе единственного экземпляра некоторого класса.
 */

// 1. Eager initialization.
class EagerInitializedSingleton {
  private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

  private EagerInitializedSingleton() {
  }

  public static EagerInitializedSingleton getInstance() {
    return instance;
  }
}

// 2. Static block initialization.
class StaticBlockSingleton {

  private static StaticBlockSingleton instance;

  private StaticBlockSingleton() {
  }

  public static StaticBlockSingleton getInstance() {
    return instance;
  }

  //static block initialization for exception handling
  static {
    try {
      instance = new StaticBlockSingleton();
    } catch (Exception e) {
      throw new RuntimeException("Exception occurs in creating singleton instance");
    }
  }
}

// 3. Lazy Initialization.
class LazyInitializedSingleton {

  private static LazyInitializedSingleton instance;

  private LazyInitializedSingleton() {
  }

  public static LazyInitializedSingleton getInstance() {
    if (instance == null) {
      instance = new LazyInitializedSingleton();
    }
    return instance;
  }
}

// 4. Lazy Initialization Thread Safe Singleton (double checked locking).
class ThreadSafeSingleton {

  private static ThreadSafeSingleton instance;

  private ThreadSafeSingleton() {
  }

  public static ThreadSafeSingleton getInstance () {
    if (instance == null) {
      synchronized (ThreadSafeSingleton.class) {
        if (instance == null) {
          instance = new ThreadSafeSingleton();
        }
      }
    }
    return instance;
  }
}

// 5. Bill Pugh Singleton Implementation (inner class instance holder).
class BillPughSingleton {

  private BillPughSingleton() {
  }

  private static class SingletonHelper {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}

// 6. Enum Singleton.
enum EnumSingleton {

  INSTANCE;
  int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
