

#ifndef LOADER_H
#define LOADER_H

#define ASCII_SOH  0x01
#define ASCII_STX  0x02
#define ASCII_EOT  0x04
#define ASCII_ACK  0x06
#define ASCII_DLE  0x10
#define ASCII_XON  0x11
#define ASCII_XOFF 0x13
#define ASCII_NAK  0x15
#define ASCII_SYN  0x16
#define ASCII_CAN  0x18
#define ASCII_EOF  0x1A

void loader_receive(void);

#endif // LOADER_H
