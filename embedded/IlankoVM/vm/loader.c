

#include "loader.h"

#include "types.h"
#include "config.h"
#include "debug.h"
#include "nvmcomm1.h"
#include "nvmcomm2.h"
#include "uart.h"
#include "delay.h"
#include "nvmfile.h"

#ifdef ASURO
#include <avr/io.h>
#endif


#ifdef NVMCOMM1
// == NVMCOMM1 ========================================================


void loader_receive(void) {
  uint8_t i, block = 1, sum = 0, len;
  uint8_t *addr = nvmfile_get_base();
  loader_t loader;

#ifdef ASURO
  // yellow status led
  PORTD |= _BV(2);
  PORTB |= _BV(0);
#endif

  // tell sender that we accept data
  uart_write_byte(ASCII_NAK);

  // wait for data with timeout
  for(sum=0;sum<250 && !uart_available();sum++)
    delay(MILLISEC(4));

  if(uart_available()) {
    nvmfile_write_initialize();
    do {
      // try to receive a full data block
      len = uart_get_block((uint8_t*)&loader, sizeof(loader));

      if(len == sizeof(loader)) {
	for(sum=0,i=0;i<LOADER_BLOCK_SIZE;i++)
	  sum += loader.data[i];

	// check for valid loader block
	if((loader.soh == ASCII_SOH) &&
	   (loader.block == block) &&
	   (loader.nblock == (0xff & ~block)) &&
	   (loader.sum == sum)) {

	  // write data to eeprom
	  for(i=0;i<LOADER_BLOCK_SIZE;i++)
	    nvmfile_write08(addr++, loader.data[i]);

	  // send ack and increase block counter
	  uart_write_byte(ASCII_ACK);
	  block++;
	} else
	  uart_write_byte(ASCII_NAK);
      } else {
	if(!len)
	  uart_write_byte(ASCII_ACK);
	else {
	  // not a full packet and not the eof marker -> nak
	  if(loader.soh != ASCII_EOF)
	    uart_write_byte(ASCII_NAK);
	}
      }
    } while((len < 1) || (loader.soh != ASCII_EOF));
    nvmfile_write_finalize();
    uart_write_byte(ASCII_ACK);

#ifdef ASURO
    // red status led
    PORTB &= ~_BV(0);

    for(;;);  // reset watchdog here if enabled
#endif
  }
#ifdef ASURO
    // green status led
    PORTD &= ~_BV(2);
#endif
}

// ====================================================================
#endif // NVMCOMM1


#ifdef NVMCOMM2
// == NVMCOMM2 ========================================================


void loader_receive(void) {
	// show status
	nvm_showstatus_booting();

	// enable NVM-Comm2
	nvc2_enable();

	// wait for 20ms communication pause
	while (true) {
		for (uint8_t i=0; !uart_available() && (i<20); ++i) delay(MILLISEC(1));
		if (uart_available()) uart_read_byte(); else break;
	}

	for (uint8_t count = 0; g_nvm_runlevel != NVM_RUNLVL_VM; ++count) {
		// wait for data with 100ms timeout
		for (uint8_t i=0; !uart_available() && (i<100); ++i) delay(MILLISEC(1));

		nvc2_check_input();

		if ( (g_nvm_runlevel == NVM_RUNLVL_BOOT) && (count >= 10) ) {
			// no incoming data, still in boot runlevel after several
			// tries, start vm
			g_nvm_runlevel = NVM_RUNLVL_VM;
		}
	}

	// show status
	nvm_showstatus_running();
}


// ====================================================================
#endif // NVMCOMM2
