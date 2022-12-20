
static inline void utils_memcpy(void *dst, void *src, uint16_t len) {
  uint8_t *dst8 = (uint8_t*)dst;
  uint8_t *src8 = (uint_t*)src;

  while(len--)
    *dst8++ = *src8++;
}

/* string len ram */
static inline u16_t utils_strlen(char *str) {
  uint16_t len=0;

  while(*str++) len++;
  return len;
}
