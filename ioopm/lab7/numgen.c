#include <stdio.h>
#include <math.h>

main( )
{
  int num = 5000;
  FILE* f = fopen("/dev/random", "r");
  int temp = 0;
  int INT = sizeof(int);
  while( num-- )
    {
      temp = 0;
      fread( &temp, INT, 1, f );
      temp = temp >> (num % 16);
      printf( "%d\n", abs(temp) );
    }
  fclose( f );
  return 0;
}
