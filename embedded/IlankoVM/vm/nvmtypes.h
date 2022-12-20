
//

#ifndef NVMTYPES_H
#define NVMTYPES_H

#include "nvmfeatures.h"

#include "types.h"

#ifdef NVM_USE_16BIT_WORD
// THE basic types
typedef uint16_t nvm_word_t;
typedef uint16_t nvm_stack_t;
typedef uint16_t nvm_ref_t;
typedef int16_t nvm_int_t;
typedef uint16_t nvm_uint_t; // needed for >>> operator
typedef int16_t nvm_short_t;
typedef int8_t nvm_byte_t;
// masks and bits of the basic type
#define NVM_IMMEDIATE_MASK  ((nvm_ref_t)0x8000)
#define NVM_TYPE_MASK       ((nvm_ref_t)0xc000)
#define NVM_TYPE_HEAP       ((nvm_ref_t)0x8000)
#define NVM_TYPE_CONST      ((nvm_ref_t)0xc000)
typedef union
{
  nvm_byte_t  b[2];
  nvm_short_t s[1];
  nvm_int_t   i[1];
} nvm_union_t;
#endif


#ifdef NVM_USE_32BIT_WORD
// THE basic types
typedef uint32_t nvm_word_t;
typedef uint32_t nvm_stack_t;
typedef uint32_t nvm_ref_t;
typedef int32_t nvm_int_t;
typedef uint32_t nvm_uint_t; // needed for >>> operator
typedef int16_t nvm_short_t;
typedef int08_t nvm_byte_t;
# ifdef NVM_USE_FLOAT
typedef float nvm_float_t;
# endif
// masks and bits of the basic type
#define NVM_IMMEDIATE_MASK  ((nvm_ref_t)0x80000000L)
#define NVM_TYPE_MASK       ((nvm_ref_t)0xc0000000L)
#define NVM_TYPE_HEAP       ((nvm_ref_t)0x80000000L)
#define NVM_TYPE_CONST      ((nvm_ref_t)0xc0000000L)
typedef union
{
  nvm_byte_t  b[4];
  nvm_short_t s[2];
  nvm_int_t   i[1];
# ifdef NVM_USE_FLOAT
  nvm_float_t f[1];
# endif
} nvm_union_t;
#endif


#endif // NVMTYPES_H
