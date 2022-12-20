

#ifndef UART_H
#define UART_H

extern void uart_init(void);
extern void uart_write_byte(uint8_t byte);
extern void uart_putc(uint8_t byte);
extern uint8_t uart_read_byte(void);
extern uint8_t uart_available(void);

#endif // UART_H
