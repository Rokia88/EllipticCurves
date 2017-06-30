package ecc;
import java.io.*;

import ecc.elliptic.NoCommonMotherException;
/** */
public interface Key {
    public Key readKey(InputStream in) throws IOException;
    public void writeKey(OutputStream out) throws IOException;
    public Key getPublic() throws NoCommonMotherException;
    public boolean isPublic();
}