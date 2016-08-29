/** DogsAndCats.cpp
 * Demonstrates inheritance and polymorphism
 * For simplicity, all methods are inlined; no separate header needed
 *
 * @author Sean Ho
 * For CMPT166
 */
#include <iostream>
using namespace std;

class Pet {
  protected:
    int numLegs;
    bool hasTail;
  public:
    Pet(int legs = 0, bool tail = true) {
      numLegs = legs;
      hasTail = tail;
    }
    virtual void speak() {
      cout << "Pet::speak() should be overriden!" << endl;
    }
};

class Dog : public Pet {
  private:
    string nameOfMaster;
  public:
    Dog() : Pet(4) {
      numLegs = 4;
      nameOfMaster = "Master";
    }
    void speak() {
      cout << "Woof!  Woof!  Hi " + nameOfMaster + "!" << endl;
    }
};

class Cat : public Pet {
  private:
    string nameOfServant;
  public:
    Cat() : Pet() {
      numLegs = 4;
      nameOfServant = "Puny Human";
    }
    void speak() {
      cout << "Meow!  Meow!  Kneel, " + nameOfServant + "!" << endl;
    }
};

void poke(Pet& mypet) {
  cout << "Poking your pet ... ";
  mypet.speak();
};

int main() {
  Dog fido;
  fido.speak();

  Pet* myPetPtr = &fido;	// upcast
  myPetPtr->speak();

  Cat sandy;
  poke(fido);
  poke(sandy);
}
