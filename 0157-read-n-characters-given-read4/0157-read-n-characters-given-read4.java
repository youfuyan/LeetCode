/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int cChar = 0, rChar = 4;
        char[] buf4 = new char[4];
        while (cChar < n && rChar == 4) {
            rChar = read4(buf4);
            for (int i = 0; i < rChar; i++) {
                if (cChar == n) {
                    return cChar;
                }
                buf[cChar] = buf4[i];
                cChar++;
            }
            
        }
        return cChar;
    }
}