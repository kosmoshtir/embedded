
#ifndef NVMFILE_H
#define NVMFILE_H

#include "types.h"
#include "vm.h"

typedef struct {
  uint8_t super;
  uint8_t fields;
} __attribute__((packed)) nvm_class_hdr_t;

typedef struct {
  uint16_t code_index;
  uint16_t id;           // class and method id
  uint8_t flags;
  uint8_t args;
  uint8_t max_locals;
  uint8_t max_stack;
} __attribute__((packed)) nvm_method_hdr_t;

typedef struct {
  u32_t magic_feature;    // old 32 bit magic is replaced by 8 bit magic and 24 feauture bits
  uint8_t version;
  uint8_t methods;          // number of methods in this file
  uint16_t main;             // index of main method
  uint16_t constant_offset;
  uint16_t string_offset;
  uint16_t method_offset;
  uint8_t static_fields;
  nvm_class_hdr_t class_hdr[];
} __attribute__((packed)) nvm_header_t;

// marker that indicates, that a method is a classes init method
#define FLAG_CLINIT 1

extern uint8_t nvmfile_constant_count;

void   nvmfile_store(uint16_t index, uint8_t *buffer, uint16_t size);

bool_t nvmfile_init(void);
void   nvmfile_call_main(void);
void   *nvmfile_get_addr(uint16_t ref);
uint8_t  nvmfile_get_class_fields(uint8_t index);
uint8_t  nvmfile_get_static_fields(void);
uint32_t  nvmfile_get_constant(uint8_t index);

void   nvmfile_read(void *dst, void *src, uint16_t len);
uint8_t  nvmfile_read08(void *addr);
uint16_t  nvmfile_read16(void *addr);
uint32_t  nvmfile_read32(void *addr);
void   nvmfile_write08(void *addr, uint8_t data);
void   *nvmfile_get_base(void);
uint8_t  nvmfile_get_method_by_class_and_id(uint8_t class, uint8_t id);

nvm_method_hdr_t *nvmfile_get_method_hdr(uint16_t index);

#ifndef NVM_USE_FLASH_PROGRAM
#define nvmfile_write_initialize() do {} while(0)
#define nvmfile_write_finalize() do {} while(0)
#else
void nvmfile_write_initialize(void);
void nvmfile_write_finalize(void);
#endif

#ifdef UNIX
void nvmfile_load(char *filename, bool_t quiet);
#endif

#define NVMFILE_SET(a)     (void*)(((ptr_t)a) | NVMFILE_FLAG)
#define NVMFILE_ISSET(a)   (((ptr_t)a) & NVMFILE_FLAG)
#define NVMFILE_ADDR(a)    (void*)(((ptr_t)a) & ~NVMFILE_FLAG)

#endif // NVMFILE_H
