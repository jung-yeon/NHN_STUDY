public interface OutputConnector {
    void connect(InputSocket socket);
    void put(Message message);

}
