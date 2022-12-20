#ifndef NATIVE_AVR_H
#define NATIVE_AVR_H

void native_avr_init(void);
void native_avr_avr_invoke(uint8_t mref);
void native_avr_port_invoke(uint8_t mref);
void native_avr_timer_invoke(uint8_t mref);
void native_avr_adc_invoke(uint8_t mref);
void native_avr_pwm_invoke(uint8_t mref);

#endif 