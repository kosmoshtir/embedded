

#ifndef EEPROM_H
#define EEPROM_H

typedef uint8_t* eeprom_addr_t;

#ifdef UNIX
#include <string.h> // for memcpy

#define eeprom_write_byte(a, d) { *a = d; }
#define eeprom_read_block(a, s, l) { memcpy(a, s, l); }
#define eeprom_write_block(a, s, l) { memcpy(s, a, l); }
#define EEPROM
#else
#ifdef AVR

// TH: Otherwise gcc-3.4.5/avr-lib-1.4.2 complain about unknow
// symbol asm ... is there a more beautiful solution?
#define asm __asm__

#include <avr/eeprom.h>
#define EEPROM __attribute__((section (".eeprom")))
#else
#warning "Unknown EEPROM setup"
#endif
#endif

#endif // UART_H
