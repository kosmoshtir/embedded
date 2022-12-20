


#include "nvmcomm1.h"

#include "uart.h"
#include "delay.h"

#ifdef ASURO
#include <avr/io.h>
#endif


#ifdef NVMCOMM1


uint8_t uart_get_block(uint8_t *data, uint8_t len) {
  uint8_t timeout, cnt = 0;

  while(len) {
    timeout = 10;  // 10 * 20ms
    while(!uart_available()) {
      // reset watchdog here if enabled
      delay(MILLISEC(20));
      if(timeout-- == 0) return cnt;
    }

    *data++ = uart_read_byte();
    len--;
    cnt++;
  }
  return cnt;
}


#endif // NVMCOMM1
