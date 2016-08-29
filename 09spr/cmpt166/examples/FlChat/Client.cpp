/* client.cpp
 * A simple program demonstrating BSD sockets.
 * This is the TCP client.
 *
 * Sean Ho for CMPT166
 */

#include "Client.h"
#include "ClientUI.h"

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>	/* sockaddr_in */
#include <arpa/inet.h>	/* inet_ntoa */
#include <netdb.h>	/* gethostbyname */
#include <sys/unistd.h>	/* close */

#include <strings.h>	/* bcopy */
#include <string.h>	/* strcpy */
#include <cstdlib>	/* exit */
#include <cstdio>	/* sprintf */

// Handle errors by printing them on the output buffer (see ClientUI)
void error(const char* txt) {
  appendOutput(txt);
}
// Same for regular debugging messages
void debug(const char* txt) {
  appendOutput(txt);
}
static char txtBuf[255];

int Client::callServer(const char* srvName, int p) {

  // Copy params to private attribs if given
  if (srvName) serverName = (char*) srvName;
  if (p) port = p;

  // Drop any existing connection
  if (clientSocket >= 0) disconnect();

  // Get a handle to a new socket object
  clientSocket = socket( AF_INET, SOCK_STREAM, 0 );
  if (clientSocket < 0) {
    error( "Couldn't allocate a socket!" );
    return -1;
  }

  // DNS lookup to find the server
  struct hostent *serverDNS = gethostbyname( serverName );
  if (serverDNS == NULL) {
    error( "Couldn't resolve server" );
    return -1;
  }

  // Fill in the address struct for the server
  struct sockaddr_in serverAddr;
  serverAddr.sin_family = AF_INET;
  serverAddr.sin_port = htons( port );
  // Byte-copy from serverDNS to serverAddr 
  bcopy( (char*) serverDNS->h_addr, (char*) &serverAddr.sin_addr.s_addr,
      serverDNS->h_length );

  sprintf(txtBuf, "Connecting to server %s on port %d",
      inet_ntoa(serverAddr.sin_addr), port);
  debug(txtBuf);

  // Connect to the server
  int er = connect( clientSocket,
      (struct sockaddr *) &serverAddr, sizeof(serverAddr) );
  if (er < 0) {
    error( "Couldn't connect to server!" );
    return -1;
  }

  debug( "Connected!" );
  return 0;
}

int Client::listenLoop() {
  if (clientSocket < 0) {
    error( "Need to connect() first!" );
    return -1;
  }

  // Keep reading from server
  char inMsg[maxMsgSize];
  for (int i=0; i<maxMsgSize; i++) inMsg[i] = 0;
  while (recv( clientSocket, inMsg, maxMsgSize, 0 ) > 0) {
    appendOutput( inMsg );
    for (int i=0; i<maxMsgSize; i++) inMsg[i] = 0;
  }

  // Done!
  disconnect();
  return 0;
}

int Client::sendMsg(const char* txt, int len) {
  if (clientSocket < 0) {
    error( "Nobody to send to!" );
    return -1;
  }
  int numBytes = send( clientSocket, txt, len, 0 );
  if (numBytes < len) {
    error( "Error sending message to the server" );
    return -1;
  }
  return 0;
}

void Client::disconnect() {
  if (clientSocket >= 0) {
    debug("Disconnected!");
    shutdown( clientSocket, 2 );
    close( clientSocket );
    clientSocket = -1;
    updateConnectStatus();	// see ClientUI
  }
}

