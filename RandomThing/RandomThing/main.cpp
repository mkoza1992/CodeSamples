#include <cstdlib>
#include <stdio.h>
#include <cstring>
#include <time.h>

//goofy program that generates a random long long, then adjusts it to make sure every byte corresponds to an alphabet character.
//this program is basically useless, and is really only made to have a little fun manipulating bytes and pointers
int main()
{
	//variables
	long long stuff;
	int size = sizeof(long long);
	int i;
	char* p;
	char c;

	//make sure the random seed is different everytime the program is run
	srand(time(NULL));	

	//generate a random int and assign to stuff
	stuff = (long long)rand();

	//since rand() returns an int and I want a long long, 
	//i shift stuff 16 bits to the left then bitwise OR it with another random int. 
	//this gives me a 'full' random long long
	stuff << 16;
	stuff = stuff | (long long)rand();

	//assign the char pointer to point at stuff's address
	p = (char*)&stuff;

	//this loop will ensure that every byte in stuff corresponds to a member of the alphabet
	for (i = 0; i < size; i++)
	{
		//checks and sees if the character currently pointed to by p is actually an alphabet char. 
		if (!((*p >= 0x41 && *p <= 0x5a) || (*p >= 0x61 && *p <= 0x7a)))
		{
			//if p is not pointing to an alphabet character, change the current byte to a random alphabet character
			c = rand()%26 + 65;
			memset(p, c, 1);
		}

		//I want every char to be uppercase
		if ((*p >= 0x61 && *p <= 0x7a))
			*p = *p - 32;		

		//increment p to point at the next byte
		p++;
	}

	//show what stuff looks like as a long long
	printf("\nAs a long long: %d\n", stuff);

	printf("\nAs a string: ");

	//this goes through 'stuff' byte by byte and prints each byte out as a char
	p = (char*)&stuff;
	for (i = 0; i < size; i++)
	{
		printf("%c", *p);
		p++;
	}
	printf( "\n\n");
}