package multiscripter.patterns.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Посредник (Mediator) - поведенческий шаблон проектирования.
 * Решает задачу взаимодействия множества объектов без необходимости хранить
 * ссылки друг на друга. Взаимодействие происходит через объект-посредник,
 * который хранит ссылки на все взаимодействующие объекты.
 */
public class MediatorTest {

  @Test
  public void showMediatorUsage() {
    PostServer server = new PostServer();

    Client client1 = new Client(server);
    client1.setId("Client-1");
    server.addClient(client1);

    Client client2 = new Client(server);
    client2.setId("Client-2");
    server.addClient(client2);

    client1.send("Client-2", "test message 1");
    client2.send("Client-1", "test message 2");
    client2.send("Client-1", "test message 3");

    assertEquals("Client: Client-2, message: test message 1", client1.getReceived());
    assertEquals("Client: Client-1, message: test message 3", client2.getReceived());
  }
}
