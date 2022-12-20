
#ifndef STACK_H
#define STACK_H

#include "vm.h"

void stack_init(uint8_t static_fields);

#ifdef NVM_USE_STACK_CHECK
void stack_save_sp(void);
void stack_verify_sp(void);
#endif

// various stack operations
void stack_push(nvm_stack_t val);
nvm_stack_t stack_pop(void);
nvm_int_t stack_pop_int(void);
nvm_stack_t stack_peek(uint8_t index);
nvm_int_t stack_peek_int(uint8_t index);
void * stack_pop_addr(void);
void * stack_peek_addr(uint8_t index);

# ifdef NVM_USE_FLOAT
nvm_float_t stack_pop_float(void);
nvm_float_t stack_peek_float(uint8_t index);
# endif


nvm_stack_t *stack_get_sp(void);
void stack_add_sp(int8_t offset);

nvm_stack_t stack_get_static(uint16_t index);
void stack_set_static(uint16_t index, nvm_stack_t value);

void stack_save_base(void);
bool_t stack_is_empty(void);

#ifdef DEBUG
uint16_t stack_get_depth(void);
#endif

bool_t stack_heap_id_in_use(heap_id_t id);

#endif // STACK_H
