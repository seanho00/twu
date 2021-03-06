// generated by Fast Light User Interface Designer (fluid) version 1.0109

#include "ServerUI.h"
#include "Server.h"
#include "fl_threads.h"
static Server *theServer; 
static Fl_Text_Buffer *outputBuffer; 

void appendOutput(const char* txt) {
  Fl::lock();
outputBuffer->append(txt);
outputBuffer->append("\n");
Fl::unlock();
Fl::awake((void*) 0);
}

static void * serverListen(void *svr) {
  ((Server*) svr)->listenLoop();
}

static Fl_Input *input=(Fl_Input *)0;

static void cb_input(Fl_Input* o, void*) {
  theServer->sendMsg(o->value(), o->size());
}

static Fl_Text_Display *output=(Fl_Text_Display *)0;

int main(int argc, char **argv) {
  Fl_Double_Window* w;
  { Fl_Double_Window* o = new Fl_Double_Window(300, 260, "Server");
    w = o;
    { input = new Fl_Input(15, 230, 275, 25, "Type a message to the client:");
      input->labelfont(1);
      input->callback((Fl_Callback*)cb_input);
      input->align(FL_ALIGN_TOP_LEFT);
      input->when(FL_WHEN_ENTER_KEY);
      input->deactivate();
      Fl_Group::current()->resizable(input);
    } // Fl_Input* input
    { output = new Fl_Text_Display(15, 20, 275, 185, "Messages from client:");
      output->color((Fl_Color)53);
      output->labelfont(1);
      output->align(FL_ALIGN_TOP_LEFT);
    } // Fl_Text_Display* output
    o->end();
  } // Fl_Double_Window* o
  Fl::lock(); // enable multithreading
outputBuffer = new Fl_Text_Buffer();
output->buffer(outputBuffer);
theServer = new Server();
theServer->init(4410);
Fl_Thread listenerThread;
fl_create_thread( listenerThread, serverListen, theServer );
  w->show(argc, argv);
  return Fl::run();
}

void updateConnectStatus() {
  Fl::lock();
if (theServer->isConnected()) {
  input->activate();
} else {
  input->deactivate();
}
Fl::unlock();
Fl::awake((void*) 0);
}
