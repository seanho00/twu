// generated by Fast Light User Interface Designer (fluid) version 1.0109

#include "ClientUI.h"
#include "Client.h"
#include "fl_threads.h"
#include <cstdlib> // atoi
static Client *theClient; 
static Fl_Text_Buffer *outputBuffer; 

static void * clientListen(void *cli) {
  ((Client*) cli)->listenLoop();
}

static Fl_Input *input=(Fl_Input *)0;

static void cb_input(Fl_Input* o, void*) {
  theClient->sendMsg(o->value(), o->size());
}

static Fl_Input *serverName=(Fl_Input *)0;

static Fl_Input *portNum=(Fl_Input *)0;

static Fl_Button *connectButton=(Fl_Button *)0;

static void cb_connectButton(Fl_Button*, void*) {
  connectToggle();
}

static Fl_Text_Display *output=(Fl_Text_Display *)0;

int main(int argc, char **argv) {
  Fl_Double_Window* w;
  { Fl_Double_Window* o = new Fl_Double_Window(300, 305, "Client");
    w = o;
    { input = new Fl_Input(15, 230, 275, 25, "Type a message to the server:");
      input->labelfont(1);
      input->callback((Fl_Callback*)cb_input);
      input->align(FL_ALIGN_TOP_LEFT);
      input->when(FL_WHEN_ENTER_KEY);
      input->deactivate();
      Fl_Group::current()->resizable(input);
    } // Fl_Input* input
    { Fl_Input* o = serverName = new Fl_Input(15, 277, 125, 23, "Server:");
      serverName->labelfont(1);
      serverName->align(FL_ALIGN_TOP_LEFT);
      o->value("localhost");
    } // Fl_Input* serverName
    { Fl_Input* o = portNum = new Fl_Input(140, 277, 55, 23, "Port:");
      portNum->type(2);
      portNum->labelfont(1);
      portNum->align(FL_ALIGN_TOP_LEFT);
      o->value("4410");
    } // Fl_Input* portNum
    { connectButton = new Fl_Button(200, 275, 89, 25, "Connect!");
      connectButton->labelfont(1);
      connectButton->callback((Fl_Callback*)cb_connectButton);
    } // Fl_Button* connectButton
    { output = new Fl_Text_Display(15, 20, 275, 185, "Messages from server:");
      output->labelfont(1);
      output->align(FL_ALIGN_TOP_LEFT);
    } // Fl_Text_Display* output
    o->end();
  } // Fl_Double_Window* o
  Fl::lock(); // enable multithreading
outputBuffer = new Fl_Text_Buffer();
output->buffer(outputBuffer);
theClient = new Client();
  w->show(argc, argv);
  return Fl::run();
}

void appendOutput(const char* txt) {
  Fl::lock();
outputBuffer->append(txt);
outputBuffer->append("\n");
updateConnectStatus();
Fl::unlock();
Fl::awake((void*) 0);
}

void updateConnectStatus() {
  if (theClient->isConnected()) {
  connectButton->label("Disconnect!");
  input->activate();
  serverName->deactivate();
  portNum->deactivate();
} else {
  connectButton->label("Connect!");
  input->deactivate();
  serverName->activate();
  portNum->activate();
}
}

int connectToggle() {
  if (theClient->isConnected()) {
  theClient->disconnect();
} else {
  theClient->callServer(serverName->value(), atoi(portNum->value()));
  Fl_Thread listenerThread;
  fl_create_thread( listenerThread, clientListen, theClient );
}
updateConnectStatus();
}