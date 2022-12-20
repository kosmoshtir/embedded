

#include "types.h"
#include "config.h"
#include "debug.h"

#ifdef DEBUG

#ifdef UNIX
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>

bool_t debug_enabled = FALSE;

void debug_enable(bool_t enable) {
  debug_enabled = enable;
}

void debugf(const char *fmt, ...) {
  if(debug_enabled) {
    va_list ap;

    va_start(ap, fmt);
    vprintf(fmt, ap);
    va_end(ap);
  }
}
#endif // UNIX

bool_t debug_isprint(uint8_t chr) {
  return(chr >= 32 && chr <= 127);
}

void debug_hexdump(void *data, uint16_t size) {
  uint16_t i,n = 0, b2c;
  uint8_t *ptr = data;

  if(!size) return;

  DEBUGF("---- dump %d bytes\n", size);

  while(size>0) {
    DEBUGF(DBG16": ", n);

    b2c = (size>16)?16:size;

    for(i=0;i<b2c;i++)
      DEBUGF(DBG8" ", ptr[i]);

    DEBUGF("  ");

    for(i=0;i<(16-b2c);i++)
      DEBUGF("   ");

    for(i=0;i<b2c;i++)
      DEBUGF("%c", debug_isprint(ptr[i])?ptr[i]:'.');

    DEBUGF("\n");

    ptr  += b2c;
    size -= b2c;
    n    += b2c;
  }
  DEBUGF("\n");
}

#endif // DEBUG
