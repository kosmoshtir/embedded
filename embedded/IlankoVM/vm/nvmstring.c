
#include "types.h"
#include "debug.h"
#include "config.h"
#include "error.h"

#ifdef NVM_USE_STDIO

#include "utils.h"
#include "vm.h"
#include "stack.h"
#include "nvmstring.h"

#ifdef NVM_USE_FORMATTER

char native_getchar(char* src) {
  // check if string resides in nvm file memory (e.g. eeprom)
  if(NVMFILE_ISSET(src))
    return nvmfile_read08(src);
  else
    return *src;
}

/* string copy to ram */
void native_strncpy(char *dst, char* src, int n) {

  // check if string resides in nvm file memory (e.g. eeprom)
  if(NVMFILE_ISSET(src))
    while(n--&&(*dst++ = nvmfile_read08(src++)));
  else
    while(n--&&(*dst++ = *src++));
}

// append a string to another one
void native_strncat(char *dst, char *src, int n) {
  while(n--&&(*dst)) dst++;         // skip string
  native_strncpy(dst, src, n);   // attach it
}

#endif

/* string copy to ram */
void native_strcpy(char *dst, char* src) {

  // check if string resides in nvm file memory (e.g. eeprom)
  if(NVMFILE_ISSET(src))
    while((*dst++ = nvmfile_read08(src++)));
  else
    while((*dst++ = *src++));
}

/* determine string length */
int16_t native_strlen(char *str) {
  int16_t len=0;

  // check if string resides in nvm file memory (e.g. eeprom)
  if(NVMFILE_ISSET(str))
    while(nvmfile_read08(str++)) len++;
  else
    while(*str++) len++;

  return len;
}

// append a string to another one
void native_strcat(char *dst, char *src) {
  while(*dst) dst++;         // skip string
  native_strcpy(dst, src);   // attach it
}

#endif // NVM_USE_STDIO
