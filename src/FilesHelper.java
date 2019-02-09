import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        byte [] bt = null;
        String text = null;
        try{
            bt = Files.readAllBytes(path);

        }
        catch (IOException e) {
            System.err.println("We found problem: "+e.toString());
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
