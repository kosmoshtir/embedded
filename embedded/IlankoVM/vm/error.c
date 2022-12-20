
#ifdef UNIX
#include <stdio.h>
#include <stdlib.h>
#else
#include <avr/io.h>
#include "delay.h"
#endif

#include "types.h"
#include "config.h"
#include "debug.h"
#include "error.h"

#ifdef UNIX
char *error_msg[] = {
  // unix message              avr error code
  "HEAP: illegal chunk size",        // A
  "HEAP: corrupted",                 // B
  "HEAP: out of memory",             // C
  "HEAP: chunk does not exist",      // D
  "HEAP: out of stack memory",       // E
  "HEAP: stack underrun",            // F
  "ARRAY: illegal type",             // G
  "NATIVE: unknown method",          // H
  "NATIVE: unknown class",           // I
  "NVMFILE: unsupported features or not a valid nvm file",   // J
  "NVMFILE: wrong nvm file version", // K
  "VM: illegal reference",           // L
  "VM: unsupported opcode",          // M
  "VM: division by zero",            // N
  "VM: stack corrupted",             // O
};
#else
#include "uart.h"
#endif

void error(err_t code) {
#ifdef UNIX
  printf("NanoVM error: %s\n", error_msg[code]);
  exit(-1);
#else

  uart_putc('E');
  uart_putc('R');
  uart_putc('R');
  uart_putc(':');
  uart_putc('A'+code);
  uart_putc('\n');

  for(;;) {
    // reset watchdog here if in use

#ifdef ASURO
    // yellow/red blinking status led
    PORTD |= _BV(2);
    PORTB |= _BV(0);
    delay(MILLISEC(250));
    PORTB &= ~_BV(0);
    delay(MILLISEC(250));
#endif
  }
#endif
}
