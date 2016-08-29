/* Client.h
 * Class declaration for TCP Client
 *
 * Sean Ho for CMPT166
 */

#ifndef CLIENT_H
#define CLIENT_H

class Client {
  private:
    char* serverName;
    int port;
    int clientSocket;
    int maxMsgSize;
  public:
    Client(char* srvName=0, int p=0) :
      serverName(srvName), port(p), clientSocket(-1), maxMsgSize(255) {}
    ~Client() { disconnect(); }
    void disconnect();
    bool isConnected() { return (clientSocket >= 0); }

    int callServer(const char* srvName=0, int p=0);
    int listenLoop();
    int sendMsg(const char* txt, int len);
};

#endif /* CLIENT_H */

