/* server.cpp
 * A simple program demonstrating BSD sockets.
 * This is the TCP server.
 *
 * Sean Ho for CMPT166
 */

#include "Server.h"
#include "ServerUI.h"

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>	/* sockaddr_in */
#include <arpa/inet.h>	/* inet_ntoa */
#include <sys/unistd.h>	/* close */

#include <cstdlib>	/* exit */
#include <cstdio>	/* sprintf */

// Handle errors by printing them on the output buffer (see ServerUI)
void error(const char* txt) {
  appendOutput(txt);
}
// Same for regular debugging messages
void debug(const char* txt) {
  appendOutput(txt);
}
static char txtBuf[255];

int Server::init(int p) {
  if (p) port = p;
  int er;

  shutdownServer();	// clean out old connection

  // Get a handle to a new socket object
  serverSocket = socket( AF_INET, SOCK_STREAM, 0 );
  if (serverSocket < 0) {
    error( "Couldn't allocate a socket!" );
    return -1;
  }

  // Fill in the address struct for the server
  struct sockaddr_in serverAddr;
  serverAddr.sin_family = AF_INET;
  serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);
  serverAddr.sin_port = htons( port );

  // Bind to the port
  er = bind( serverSocket, 
      (struct sockaddr *) &serverAddr, sizeof(serverAddr) );
  if (er < 0) {
    error( "Couldn't bind to the port!" );
    shutdownServer();
    return -1;
  }

  // Enable for listening; set incoming connection queue length
  er = listen( serverSocket, 5 );
  if (er < 0) {
    error( "Couldn't enable socket for listening!" );
    shutdownServer();
    return -1;
  }

  debug("Server ready");
  return 0;
}

int Server::listenLoop() {
  if (serverSocket < 0) return -1;

  while (1) {

    // accept() stores client "caller ID" info here
    struct sockaddr_in clientAddr;
    socklen_t cAddrLen = sizeof(clientAddr);

    sprintf(txtBuf, "Listening on port %d", port);
    debug(txtBuf);

    // Wait for client connection
    connectionSocket = accept( serverSocket, 
	(struct sockaddr *) &clientAddr, &cAddrLen);
    if (connectionSocket < 0) {
      error( "Problem accepting connection from client!" );
      return 0;
    }

    // Print client info
    sprintf(txtBuf, "Connected to %s from port %d",
      inet_ntoa(clientAddr.sin_addr), clientAddr.sin_port);
    debug(txtBuf);

    updateConnectStatus();	// see ServerUI

    // Keep reading from client
    char inMsg[maxMsgSize];
    for (int i=0; i<maxMsgSize; i++) inMsg[i] = 0;
    while ((connectionSocket >= 0) &&
	(recv( connectionSocket, inMsg, maxMsgSize, 0 ) > 0)) {
      appendOutput( inMsg );
      for (int i=0; i<maxMsgSize; i++) inMsg[i] = 0;
    }

    // Done!
    disconnectClient();

  }
  return 0;
}

int Server::sendMsg(const char* txt, int len) {
  if (connectionSocket < 0) {
    error( "Nobody to send to!" );
    return -1;
  }
  int numBytes = send( connectionSocket, txt, len, 0 );
  if (numBytes < len) {
    error( "Error sending message to the client" );
    return -1;
  }
  return 0;
}

void Server::disconnectClient() {
  if (connectionSocket >= 0) {
    shutdown(connectionSocket, 2);
    close(connectionSocket);
    connectionSocket = -1;
  }
  updateConnectStatus();	// see ServerUI
}

void Server::shutdownServer() {
  disconnectClient();
  if (serverSocket >= 0) {
    shutdown(serverSocket, 2);
    close(serverSocket);
    serverSocket = -1;
  }
}
