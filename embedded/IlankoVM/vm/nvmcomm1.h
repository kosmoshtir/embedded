

#ifndef NVMCOMM1_H
#define NVMCOMM1_H


#ifndef NVMCOMM2
#define NVMCOMM1
#endif


#include "types.h"
#include "config.h"
#include "debug.h"


#ifdef __cplusplus
extern "C" {
#endif

#ifdef NVMCOMM1



#define LOADER_BLOCK_SIZE  16

typedef struct {
  uint8_t soh;
  uint8_t block, nblock;
  uint8_t data[LOADER_BLOCK_SIZE];
  uint8_t sum;
} __attribute__((packed)) loader_t;


uint8_t uart_get_block(uint8_t *data, uint8_t len);



#endif // NVMCOMM1

#ifdef __cplusplus
}
#endif

#endif // NVMCOMM1_H
