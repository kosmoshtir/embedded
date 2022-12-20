#include "types.h"
#include "config.h"
#include "debug.h"
#include "error.h"

#include "vm.h"
#include "array.h"
#include "heap.h"

#ifdef NVM_USE_ARRAY

uint8_t array_typelen(uint8_t type) {
  if((type == T_BOOLEAN)||(type == T_CHAR)||(type == T_BYTE))
    return sizeof(nvm_byte_t);
  
  if(type == T_SHORT)
    return sizeof(nvm_short_t);
  if(type == T_INT)
    return sizeof(nvm_int_t);

  error(ERROR_ARRAY_ILLEGAL_TYPE);
  return 0;  // to make compiler happy
}

heap_id_t array_new(nvm_int_t length, uint8_t type) {
  DEBUGF("newarray type %d len = %d: ", type, length);
  DEBUGF("total size = %d bytes\n", length * array_typelen(type));

  heap_id_t id = heap_alloc(FALSE, 1 + length * array_typelen(type));

  // store type in first byte
  *(uint8_t*)(heap_get_addr(id)) = type;

  return id;
}

nvm_int_t array_length(heap_id_t id) {
  DEBUGF("arraylength %d = %d/%d\n", id, 
	 heap_get_len(id),
	 array_typelen(*(uint8_t*)heap_get_addr(id)));

  return(heap_get_len(id)/
	 array_typelen(*(uint8_t*)heap_get_addr(id)));
}
 
void array_bastore(heap_id_t id, nvm_int_t index, nvm_byte_t value) {
  nvm_byte_t * ptr = (nvm_byte_t *)heap_get_addr(id) + 1;
  DEBUGF("bastore id=%x, index=%d, value=%d\n", id, index, value);
  ptr[index] = value;
}

nvm_byte_t array_baload(heap_id_t id, nvm_int_t index) {
  nvm_byte_t * ptr = (nvm_byte_t*)heap_get_addr(id) + 1;
  DEBUGF("baload id=%x, index=%d\n", id, index);
  return ptr[index];
}

void array_iastore(heap_id_t id, nvm_int_t index, nvm_int_t value) {
  nvm_int_t * ptr = (nvm_int_t *)((uint8_t*)heap_get_addr(id) + 1);
  DEBUGF("iastore id=%x, index=%d, value=%d\n", id, index, value);
  ptr[index] = value;
  HEAP_CHECK();
}

nvm_int_t array_iaload(heap_id_t id, nvm_int_t index) {
  nvm_int_t * ptr = (nvm_int_t *)((uint8_t*)heap_get_addr(id) + 1);
  DEBUGF("iaload id=%x, index=%d\n", id, index);
  return ptr[index];
}

#ifdef NVM_USE_FLOAT
void array_fastore(heap_id_t id, nvm_int_t index, nvm_float_t value) {
  nvm_float_t * ptr = (nvm_float_t*)((uint8_t*)heap_get_addr(id) + 1);
  DEBUGF("iastore id=%x, index=%d, value=%f\n", id, index, value);
  ptr[index] = value;
  HEAP_CHECK();
}

nvm_float_t array_faload(heap_id_t id, nvm_int_t index) {
  nvm_float_t * ptr = (nvm_float_t*)((uint8_t*)heap_get_addr(id) + 1);
  DEBUGF("iaload id=%x, index=%d\n", id, index);
  return ptr[index];
}
#endif