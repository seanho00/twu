/* server.cpp
 * A simple program demonstrating BSD sockets.
 * This is the TCP server.
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
#endif

#include <iostream>
using namespace std;

#include <cstdlib>	/* exit */

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
  int serverSID = socket( AF_INET, SOCK_STREAM, 0 );
  if (serverSID < 0) checkErr( serverSID, "Couldn't allocate a socket" );

  // Fill in the address struct for the server
  struct sockaddr_in serverAddr;
  serverAddr.sin_family = AF_INET;
  serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);
  serverAddr.sin_port = htons(SERVER_PORT);

  // Bind to the port
  checkErr(
      bind( serverSID, (struct sockaddr *) &serverAddr, sizeof(serverAddr) ),
      "Couldn't bind to the port");

  // Enable for listening; set incoming connection queue length
  checkErr(
      listen( serverSID, 5 ),
      "Couldn't enable socket for listening");

  for (int i=0; i<2; i++) {	// loop a few times

    cout << "Listening on port " << ntohs(serverAddr.sin_port)
      << " on address " << inet_ntoa(serverAddr.sin_addr) << endl;

    // accept() stores client "caller ID" info here
    struct sockaddr_in clientAddr;
    socklen_t cAddrLen = sizeof(clientAddr);

    // Wait for client connection
    int connectID = accept( serverSID, (struct sockaddr *) &clientAddr, &cAddrLen);
    if (connectID < 0)
      checkErr( connectID, "Problem accepting connection from client" );

    // Print client info
    cout << "Connected to "
      << inet_ntoa(clientAddr.sin_addr) << " from port "
      << clientAddr.sin_port << "; listening...";

    // Connected!  Listen for a message from the client
    int numBytes;
    char inMsg[MESSAGE_SIZE];
    numBytes = recv( connectID, inMsg, MESSAGE_SIZE, 0 );
    cout << endl;
    checkErr( numBytes, "Couldn't receive anything from client" );
    cout << "From client:" << endl << "<< " << inMsg << endl;

    // Send a message to the client
    cout << "Type a message to send to the client:" << endl;
    cout << ">> ";
    string outMsg;
    getline( cin, outMsg );
    numBytes = send( connectID, outMsg.c_str(), outMsg.length()+1, 0 );
    checkErr( numBytes, "Couldn't send message to the client" );

    // Clean up
    cout << "All done with this client!" << endl;
    shutdown( connectID, 2 );
    close( connectID );
  }

  cout << "All done!" << endl;
  return(0);
}


