package com.yi.interviewquestions.Facebook;

public class ReadNCharactersGivenRead4 {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

        char[] buffer = new char[4];
        int readBytes = 0;
        boolean endofFile = false;

        while(readBytes<n && !endofFile){
            int actualCharactersRead = read4(buffer);
            if(actualCharactersRead!= 4){
                endofFile = true;
            }

            int l = Math.min(n-readBytes, actualCharactersRead);
            for(int i = 0; i< l ;i++){
                buf[readBytes+i] = buffer[i];
            }
            readBytes = readBytes+l;
        }
        return readBytes;

    }

    public int read4(char[] buffer){return 0;}

}
