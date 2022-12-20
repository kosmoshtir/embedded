

#ifndef TYPES_H
#define TYPES_H

#ifdef __cplusplus
extern "C" {
#endif


#ifndef NULL
#define NULL ((void*)0)
#endif

#define PACKED __attribute__ ((packed))

#include <inttypes.h>
 // A byte-sized ssize_t


#if !defined __cplusplus

#ifndef bool
typedef _Bool     bool;
#endif

#ifndef false
#define false 0
#endif

#ifndef FALSE
#define FALSE false
#endif

#ifndef true
#define true (!false)
#endif

#ifndef TRUE
#define TRUE true
#endif

#ifndef min
#define min(X,Y) ((X) < (Y) ? (X) : (Y))
#endif

#ifndef max
#define max(X,Y) ((X) > (Y) ? (X) : (Y))
#endif

#endif // !defined __cplusplus


/* the minimum integer, that can hold a pointer type */
#ifdef AVR
typedef uint16_t         ptr_t;
#else
typedef uint32_t         ptr_t;
#endif


#ifdef __cplusplus
}
#endif

#endif // TYPES_H
