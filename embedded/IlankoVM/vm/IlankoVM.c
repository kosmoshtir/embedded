

#ifdef UNIX
#include <stdio.h>
#endif // UNIX

#include "types.h"
#include "config.h"
#include "debug.h"

#include "loader.h"
#include "uart.h"
#include "nvmfile.h"
#include "vm.h"

// hooks for init routines

#include "native_impl.h"

/*
#ifdef ASURO
#include "native_asuro.h"
#endif

#ifdef NATIVE_AVR
#include "native_avr.h"
#endif

*/

#ifdef LCD
#include "native_lcd.h"
#endif

int main(int argc, char **argv) {

#ifndef CTBOT
#ifndef NIBO
  uart_init();
#endif
#endif

  // call native initialization (e.g. hardware setup)
#ifdef NATIVE_INIT
  NATIVE_INIT;
#endif

#ifdef UNIX
  // parse unix command line options and load
  // nvm file if requested
  int i = 1, quiet = 0;

  debug_enable(FALSE);

  // parse options
  while((i<argc)&&(argv[i][0] == '-')) {
    if(argv[i][1] == 'd')
      debug_enable(TRUE);

    if(argv[i][1] == 'q')
      quiet = TRUE;

    i++;
  }

  if(!quiet)
    printf("IlankoVM " VERSION " runtime (c) 2020-2022 Ilya Koptyug\n");

  // load translated class file
  if((i<argc)&&(argv[i][0] != '-')) {
    nvmfile_load(argv[i], quiet);
  } else
    printf("running pre-installed default\n");
#endif // UNIX

#ifndef CTBOT
#ifndef NIBO
  // wait 1 sec for upload
  loader_receive();
#endif
#endif

  nvmfile_init();

  vm_init();

  nvmfile_call_main();

#ifdef UNIX
  // the following is only being done to detect memory leaks and
  // heap corruption and can thus be omitted on the real thing (tm)

  // give main args back to heap
  heap_unsteal(1*sizeof(nvm_stack_t));

  heap_garbage_collect();
  heap_show();
#endif // UNIX

  DEBUGF("main() returned\n");

#ifndef UNIX
  // don't care for anything after this ...
  for(;;);  // reset wdt if in use
#endif  // UNIX

  return 0;
}
