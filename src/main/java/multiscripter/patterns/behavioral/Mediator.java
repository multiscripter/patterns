package multiscripter.patterns.behavioral;

import java.util.HashMap;

/**
 * Посредник (Mediator) - поведенческий шаблон проектирования.
 * Решает задачу взаимодействия множества объектов без необходимости хранить
 * ссылки друг на друга. Взаимодействие происходит через объект-посредник,
 * который хранит ссылки на все взаимодействующие объекты.
 */

/**
 * Пример.
 * Дано:
 * Почтовый сервер и клиенты.
 * Задача:
 * Разработать систему пересылки сообщений между почтовыми клиентами.
 */

/**
 * Класс, объекты которого зваимодействуют через посредника.
 * (Colleague).
 */
class Client {

  private String id;

  private PostServer server;

  private String received;

  public Client(PostServer server) {
    this.server = server;
  }

  public void send(String to, String message) {
    this.server.send(id, to, message);
  }

  public void notify(String from, String message) {
    this.received = String.format("Client: %s, message: %s", from,  message);
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getReceived() {
    return this.received;
  }
}

/**
 * Посредник (Mediator).
 */
class PostServer {

  private HashMap<String, Client> clients;

  public PostServer() {
    this.clients = new HashMap<String, Client>();
  }

  public void send(String id , String to, String message) {
    this.clients.get(id).notify(to, message);
  }

  public void addClient(Client client) {
    this.clients.put(client.getId(), client);
  }
}
