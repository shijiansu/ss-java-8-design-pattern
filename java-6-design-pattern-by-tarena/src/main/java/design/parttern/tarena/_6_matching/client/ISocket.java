package design.parttern.tarena._6_matching.client;

public interface ISocket {
  void connect();

  void disconnect();

  void send();

  void receive();
}
