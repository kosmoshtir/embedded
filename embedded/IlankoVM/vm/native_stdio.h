

#ifndef NATIVE_STDIO_H
#define NATIVE_STDIO_H

void native_java_io_printstream_invoke(uint8_t mref);
void native_java_io_inputstream_invoke(uint8_t mref);
void native_java_lang_stringbuffer_invoke(uint8_t mref);
void native_itoa(char *str, nvm_int_t val);

#endif // NATIVE_STDIO_H
