#include <stdio.h>

int main() {
    char name[] = "Satyam Singh";
    int count = 0;
    
    for (int i = 0; name[i] != '\0'; i++) {
        count++;
    }
    
    printf("%d\n", count);
    
    return 0;
}
