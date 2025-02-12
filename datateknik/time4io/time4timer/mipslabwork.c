/* mipslabwork.c

   This file written 2015 by F Lundevall
   Updated 2017-04-21 by F Lundevall

   This file should be changed by YOU! So you must
   add comment(s) here with your name(s) and date(s):

   This file modified 2017-04-31 by Ture Teknolog

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "mipslab.h"  /* Declatations for these labs */
int i=0;
int mytime = 0x5957;

char textstring[] = "text, more text, and even more text!";

/* Interrupt Service Routine */
void user_isr( void )
{
  return;
}

/* Lab-specific initialization goes here */
void labinit( void )
{
volatile int *pek = &0xbf886100;
 *pek = 0;

 TRISDSET = 0x0fe0;

  return;
}

/* This function is called repetitively from the main program */
void labwork( void )
{
  delay( 1000 );
  time2string( textstring, mytime );
  display_string( 3, textstring );
  display_update();
  tick( &mytime );
  i++;
  display_image(96, icon);
  // getbtns();
  // getsw();
  volatile int* b = (volatile int*)0xbf886110;
  *b = i;



 if(getbtns() & 0x1==1)
  {
    mytime= mytime & 0xff0f |getsw() << 4;
  }
 if(getbtns() & 0x2 ==0x2)
  {
    mytime = mytime &0xf0ff |getsw()<< 8;
  }
 if(getbtns() & 0x4 == 0x4)
  {
    mytime =mytime & 0x0fff |getsw()<< 12;
  }

}
