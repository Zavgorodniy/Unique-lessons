package IO;

import java.io.*;

public class InOut {

    // ����� ��� ������ �����
    private InputStream is;

    // ����� ��� ������ � ����
    private OutputStream os;

    // ���� � ����� ������� ����� ������ � ����������
    private String path;

    public InOut(String path) {
        this.path = path;
    }

    // ������ ����� ��������� InputStream
    public void read() throws IOException {

        File file = new File(path);

        is = new FileInputStream(file);

        int i =- 1;
        while((i = is.read()) != -1) {
            System.out.print((char) i);
        }

        is.close();
    }

    public void write(String st) throws IOException {

        File file = new File(path);

        os = new FileOutputStream(file);

        os.write(st.getBytes());

        os.close();
    }

}
