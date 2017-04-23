/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testnettyclient;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author philb
 */
public class MainClient {

    public static void main(String[] args) throws Exception {
        try (Socket s = new Socket("192.168.0.10", 5678)) {
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            InputStream is = s.getInputStream();

            writer.println("Howdy!");
            writer.flush();

            StringBuilder response = new StringBuilder();

            int c;
            while ((c = is.read()) != -1) {
                response.append((char)c);
            }

            System.out.println("Got response -->" + response + "<--");
        }
    }

}
