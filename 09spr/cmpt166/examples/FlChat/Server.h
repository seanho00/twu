/* Server.h
 * Class declaration for TCP Server
 *
 * Sean Ho for CMPT166
 */

#ifndef SERVER_H
#define SERVER_H

class Server {
  private:
    int port;
    int serverSocket;
    int connectionSocket;
    int maxMsgSize;
  public:
    Server(int p=0) : 
      port(p), serverSocket(-1), connectionSocket(-1), maxMsgSize(255) {};
    void disconnectClient();
    void shutdownServer();
    ~Server() { shutdownServer(); }
    bool isConnected() { return (connectionSocket >= 0); }

    int init(int p=0);
    int listenLoop();
    int sendMsg(const char* txt, int len);
};

#endif /* SERVER_H */
