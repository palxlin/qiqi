package com.csi.util;

import java.io.*;

/**
 * Created by Lin on 2017/11/5.
 */
public class FileUtil {

    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String LINE_SEPARATOR = (String) System.getProperty("line.separator");

    private static final String MODE_R = "r";
    private static final String MODE_RWS = "rws";

    private FileUtil() {}

    //////// load file

    public static String loadFileAsString(String file) {
        return loadFileAsString(file, DEFAULT_CHARSET);
    }

    public static String loadFileAsString(String file, String charset){
        return loadFileAsString(new File(file), charset);
    }

    public static String loadFileAsString(File file, String charset) {
        byte[] content = loadFileAsByteArray(file);
        return newString(content, charset);
    }


    public static byte[] loadFileAsByteArray(File file){
        RandomAccessFile raf = newRandomAccessFile(file, MODE_R);

        try{
            byte[] b = new byte[(int) raf.length()];
            raf.read(b);

            return b;
        } catch (Exception e ){
            e.printStackTrace();
            return null;
        } finally {
            close(raf);
        }
    }

    ////////////////// wrapper for handle exception

    public static RandomAccessFile newRandomAccessFile(File file, String mode) {
        try{
            return new RandomAccessFile(file, mode);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String newString(byte[] src, String charset){
        try {
            return new String(src, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Closeable c) {
        if (c!=null){
            try {
                c.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
