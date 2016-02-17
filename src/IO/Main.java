package IO;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        InOut inOut = new InOut("src/IO/file.txt");

        try {
            inOut.read();
//            inOut.write("my name is Nick");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
