
//

#ifndef NVM_STRING_H
#define NVM_STRING_H

void native_strcpy(char *dst, char* src);
void native_strncpy(char *dst, char* src, int n);
int16_t native_strlen(char *str);
void native_strcat(char *dst, char *src);
void native_strncat(char *dst, char *src, int n);
char native_getchar(char* src);


#endif // NVM_STRING_H
