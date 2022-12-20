#include "heap.h"

#define T_BOOLEAN 4
#define T_CHAR 	  5
#define T_FLOAT   6  // not allowed in mvm
#define T_DOUBLE  7  // not allowed in mvm
#define T_BYTE 	  8
#define T_SHORT   9
#define T_INT 	 10
#define T_LONG 	 11  // not allowed in mvm

heap_id_t   array_new(nvm_int_t length, uint8_t type);
nvm_int_t   array_length(heap_id_t id);
void	    array_bastore(heap_id_t id, nvm_int_t index, nvm_byte_t value);
nvm_byte_t  array_baload(heap_id_t id, nvm_int_t index);
void        array_iastore(heap_id_t id, nvm_int_t index, nvm_int_t value);
nvm_int_t   array_iaload(heap_id_t id, nvm_int_t index);
#ifdef NVM_USE_FLOAT
void        array_fastore(heap_id_t id, nvm_int_t index, nvm_float_t value);
nvm_float_t array_faload(heap_id_t id, nvm_int_t index);
#endif