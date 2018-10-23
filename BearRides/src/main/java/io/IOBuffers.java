/*
 * Contributors: Ash
 * Description: this serves to define input and out buffers in one place
 * Date Last Modified: 10/22/2018
 */

package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class IOBuffers {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public IOBuffers(File file) {
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //variable not to be saved upon shutdown
    public Scanner in;
    public BufferedWriter out;
}