

#ifndef DEBUG_H
#define DEBUG_H

#include "config.h"
#include "types.h"

#define DBG8 "%02x"
#define DBG16 "%04x"
#define DBG32 "%08x"

#ifdef DEBUG
#define DEBUGF(...)  debugf(__VA_ARGS__)
#define DEBUG_HEXDUMP(a,b) debug_hexdump(a,b)
void debugf(const char *fmt, ...);
void debug_hexdump(void *data, uint16_t size);
#else
#define DEBUGF(...)
#define DEBUG_HEXDUMP(a,b)
#endif

void debug_enable(bool_t enable);

#endif //DEBUG_H
