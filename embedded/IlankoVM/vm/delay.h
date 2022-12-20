//

#ifndef DELAY_H
#define DELAY_H

#include "types.h"
#include "config.h"

#ifdef UNIX
#include <unistd.h>

#define MICROSEC(a) (a)
#define MILLISEC(a) ((a)*1000)
#define SEC(a)      ((a)*1000000)

#define delay(a)  usleep(a)
#else

#ifdef AVR

#define MICROSEC(a) ((a)*CLOCK/7000000)
#define MILLISEC(a) ((a)*CLOCK/7000)
#define SEC(a)      ((a)*CLOCK/7)

//#define nop() ({__asm__ __volatile__ ("nop\n\t":);})

/* nop/1, subi/1, sbc/1, sbc/1, sbc/1, brcc/2 -> 7 clocks */
static inline void delay(uint32_t delay_cnt) {
  while(delay_cnt--) {__asm__ __volatile__ ("nop\n\t":);}
}

#endif // nAVR
#endif // nUNIX

#endif // DELAY_H
