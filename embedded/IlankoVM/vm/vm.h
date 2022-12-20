

#ifndef VM_H
#define VM_H

#include "nvmtypes.h"
#include "heap.h"
#include "nvmfile.h"

// additional items to be allocated on heap during constructor call
#define VM_CLASS_CONST_ALLOC  1

void   vm_init(void);
void   vm_run(uint16_t mref);
bool vm_heap_id_in_use(heap_id_t id);

// expand types
void * vm_get_addr(nvm_ref_t ref);

#define nvm_int2stack(x) (~NVM_IMMEDIATE_MASK & (x))
nvm_int_t nvm_stack2int(nvm_stack_t val);

#define nvm_ref2stack(x) (x)
#define nvm_stack2ref(x) (x)

#ifdef NVM_USE_FLOAT
nvm_stack_t nvm_float2stack(nvm_float_t val);
nvm_float_t nvm_stack2float(nvm_stack_t val);
#endif


#endif // VM_H
