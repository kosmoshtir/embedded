

#ifndef HEAP_H
#define HEAP_H

#if HEAPSIZE <= 1024
typedef uint8_t heap_id_t;
#else
typedef uint16_t heap_id_t;
#endif

void      heap_init(void);
uint8_t     *heap_get_base(void);
void      heap_show(void);
heap_id_t heap_alloc(bool_t fieldref, uint16_t size);
void      heap_realloc(heap_id_t id, uint16_t size);
uint16_t     heap_get_len(heap_id_t id);
void      *heap_get_addr(heap_id_t id);
//hey, this is java!!!  void      heap_free(heap_id_t id);
void      heap_garbage_collect(void);
void      heap_steal(uint16_t bytes);
void      heap_unsteal(uint16_t bytes);

#ifdef DEBUG_JVM
void      heap_check(void);
#define HEAP_CHECK()  heap_check()
#else
#define HEAP_CHECK()
#endif

#endif // HEAP_H
