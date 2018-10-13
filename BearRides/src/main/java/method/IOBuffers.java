package method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//define input and out buffers for use throught the program here
public class IOBuffers {
    
    public IOBuffers() {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public Scanner in;
    public BufferedWriter out;
}