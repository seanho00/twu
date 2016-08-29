/* client.cpp
 * A simple program demonstrating BSD sockets.
 * This is the TCP client.
 *
 * Sean Ho for CMPT166
 */

#ifdef WIN32
#  include <winsock2.h>
#else
#  include <sys/types.h>
#  include <sys/socket.h>
#  include <netinet/in.h>	/* sockaddr_in */
#  include <arpa/inet.h>	/* inet_ntoa */
#  include <netdb.h>	/* gethostbyname */
#endif

#include <strings.h>	/* bcopy */
#include <cstdlib>	/* exit */

#include <string>
#include <iostream>
using namespace std;

#define SERVER_HOST "localhost"
#define SERVER_PORT 4410
#define MESSAGE_SIZE 255

// helper function checks if we got an error code
void checkErr(int errorCode, const char *errorText) {
  if (errorCode < 0) {
    cerr << errorText << endl;
    exit(0);
  }
}

int main(int argc, char* argv[]) {

  // Get a handle to a new socket object
  int clientSID = socket( AF_INET, SOCK_STREAM, 0 );
  if (clientSID < 0) checkErr( clientSID, "Couldn't allocate a socket" );

  // DNS lookup to find the server
  struct hostent *serverDNS = gethostbyname(SERVER_HOST);
  if (serverDNS == NULL) checkErr( -1, "Couldn't resolve server" );

  // Fill in the address struct for the server
  struct sockaddr_in serverAddr;
  serverAddr.sin_family = AF_INET;
  serverAddr.sin_port = htons(SERVER_PORT);
  // Byte-copy from serverDNS to serverAddr 
  bcopy( (char*) serverDNS->h_addr, (char*) &serverAddr.sin_addr.s_addr,
      serverDNS->h_length );

  cout << "Connecting to server " << inet_ntoa(serverAddr.sin_addr)
      << " on port " << SERVER_PORT << endl;

  // Connect to the server
  checkErr(
      connect( clientSID, (struct sockaddr *) &serverAddr, sizeof(serverAddr) ),
      "Couldn't connect to server" );

  int numBytes;
  cout << "Connected!  Please type a message to send" << endl;
  cout << ">> ";
  string outMsg;
  getline( cin, outMsg );
  numBytes = send( clientSID, outMsg.c_str(), outMsg.length()+1, 0 );
  checkErr( numBytes, "Couldn't send message to the server" );

  // Read a message from server
  cout << "Waiting for response from server...";
  char inMsg[MESSAGE_SIZE];
  numBytes = recv( clientSID, inMsg, MESSAGE_SIZE, 0 );
  cout << endl;
  checkErr( numBytes, "Couldn't receive anything from server" );
  cout << "From server:" << endl << "<< " << inMsg << endl;

  // Clean up
  cout << "All done!" << endl;
  shutdown( clientSID, 2 );
  close( clientSID );
}
