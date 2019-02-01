import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.*;
import java.nio.file.Files;

public class FilesHelper {
    private Files file;
    private Path path;

    public FilesHelper(String _path)
    {
        path = Paths.get(_path);
        try{
            file.createFile(path);
        } catch (FileAlreadyExistsException e){
            System.out.println("File exist: "+ e.toString());
        }
        catch (IOException e){
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    public String readAllFile() {
        System.out.println("We start reading file");
        byte [] bt = null;
        try{
            bt = Files.readAllBytes(path);
        } catch (IOException e)
        {
            System.err.println("We found: "+e.toString());
            System.exit(1999);
        }
        return new String(bt);
    }

    public void save (String toSave) {
        try{
            Files.write(path, toSave.getBytes());
        }   catch (IOException e)
        {
            System.err.println("EROOR:  "+e.toString());
            System.exit(1999);
        }
    }
}
