package design.parttern.tarena._6_matching.client;

import design.parttern.tarena._6_matching.other.SomewhereSocket;

public class SocketImpl implements ISocket {
  @Override
  public void connect() {
    System.out.println("Tarena socket 开始启用！");
    SomewhereSocket.connect();
  }

  @Override
  public void disconnect() {
    SomewhereSocket.disConnect();
    System.out.println("Tarena Socket 断开连接！");
  }

  @Override
  public void receive() {
    SomewhereSocket.receive();
  }

  @Override
  public void send() {
    SomewhereSocket.send();
  }
}
