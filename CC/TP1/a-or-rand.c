#include <stdio.h>
#include <stdlib.h>

int main()
{
    char c = 'c';

    while (c != 'A')
    {
        scanf("%c", &c);
        printf("random number :%d.\n", rand());
    }
    return 1;
}