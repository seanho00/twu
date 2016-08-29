// BankInterest.h
// Header file for BankInterest logic

#ifndef _BANKINTEREST_H_
#define _BANKINTEREST_H_

// Constants
#define COMPOUND_INTERVAL 0.25		// quarterly

// Declare functions
float calc_balance(float init_bal, float rate, 
    float* widthdrawals, unsigned int num_widthdrawals);

#endif /* _BANKINTEREST_H_ */
