import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class WriteFile{
    
    private String path;
    private boolean appendToFile=false;

    public WriteFile(String filePath){
        path=filePath;
    }
    public WriteFile(String filePath,boolean appendValue){
        path=filePath;
        appendToFile=appendValue;
    }
    
    public void writeToFile(String textLine)throws IOException{
        FileWriter write=new FileWriter(path,appendToFile);
        PrintWriter printLine=new PrintWriter(write);

        printLine.printf("%s"+"%n",textLine);
        printLine.close();
    }

    public void clearFile()throws IOException{
        FileWriter write = new FileWriter(path, false); 
        PrintWriter printLine = new PrintWriter(write, false);
        printLine.flush();
        printLine.close();
        write.close();
    }
    
     public void newFile() throws IOException{
    	FileWriter write = new FileWriter(path, true); 
    	write.close();
    }
}