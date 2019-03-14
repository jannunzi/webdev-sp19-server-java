/**
 * @title cgi_decode
 * @desc
 * Translate a string from the CGI encoding to plain ascii text
 * ’+’ becomes space, %xx becomes byte with hex value xx,
 * other alphanumeric characters map to themselves *
 * returns 0 for success, positive for erroneous input
 * 1 = bad hexadecimal digit */
int cgi_decode(char *encoded, char *decoded) {
    char *eptr = encoded;
    char *dptr = decoded;
    int ok = 0;


while(*eptr) { /* loop to end of string ('\0' character) */
    char c;
    c = *eptr;
    if (c == '+') { /* '+' maps to blank */
        *dptr = ' ';
    } else if(c == '%') { /* '%xx' is hex for char xx */
        int digit_high = Hex_Values[*(++eptr)];
        int digit_low  = Hex_Values[*(++eptr)];
        if(digit_high == -1 || digit_low == -1) {
            ok = 1; /* Bad return code */
        } else {
            *dptr = 16*digit_high+digit_low;
        } else { /* All other characters map to themselves */
            *dptr = *eptr;
        }
        ++dptr;
        ++eptr;
    }
    *dptr = '\0';
    return ok;
}