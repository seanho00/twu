// BankInterest.cxx
// Calculate the final balance after four widthdrawals.
// This file holds the main program logic; GUI stuff goes in BankInterest.fl
//
// Sean Ho for CMPT166

#include "BankInterest.h"

// Update the final balance:
// widthdrawals is an array of widthdrawal amounts;
// num_widthdrawals is the number of elements in that array
float calc_balance(float init_bal, float rate, 
    float* widthdrawals, unsigned int num_widthdrawals) {

  float balance = init_bal;

  for (int i=0; i<num_widthdrawals; i++) {
    balance += balance * COMPOUND_INTERVAL * rate / 100;
    balance -= widthdrawals[i];
  }
  
  return balance;
}
