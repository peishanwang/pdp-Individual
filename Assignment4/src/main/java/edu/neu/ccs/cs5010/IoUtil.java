package edu.neu.ccs.cs5010;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * IoUtil is used to read text from file and output file.
 */
public class IoUtil implements IIoUtil {
  private String path;
  private String encoding;

  /**
   * Constructor of IoUtil.
   * @param path path of input/output file
   * @param encoding encoding type used when read/write text from/to file
   */
  public IoUtil(String path, String encoding) {
    this.path = path;
    this.encoding = encoding;
  }

  @Override
  public List<String> getInput() {
    List<String> list = new ArrayList<>();
    try {
      InputStreamReader isr = new InputStreamReader(new FileInputStream(path), encoding);
      BufferedReader bfr = new BufferedReader(isr);
      String line;
      while ((line = bfr.readLine()) != null) {
        list.add(line);
      }
      bfr.close();
    } catch (IOException e) {
      throw new RuntimeException("Can not find file: " + path);
    }
    return list;
  }

  @Override
  public void generateOutput(List<String> result, String fileName) {
    File directory = new File(path);
    try {
      boolean folderExisted = directory.exists() || directory.mkdirs();
      if (!folderExisted) {
        throw new IOException("Unable to create path");
      }
      OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path + fileName),
          encoding);
      BufferedWriter bfw = new BufferedWriter(osw);
      for (int i = 0; i < result.size(); i++) {
        bfw.write(result.get(i));
        bfw.newLine();
      }
      bfw.close();
      System.out.println(fileName + " Done");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof IoUtil)) {
      return false;
    }
    IoUtil other = (IoUtil) object;
    boolean result = (this.path.equals(other.path))
        && (this.encoding.equals(other.encoding));
    return result;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + this.path.hashCode();
    result = 31 * result + this.encoding.hashCode();
    return result;
  }

}
