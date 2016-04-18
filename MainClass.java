import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Ruoting Li
 * @version (2016.04.12)
 */
public class MainClass
    implements IHuffConstants
{
    // add main method
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param args
     */
    public static void main(String[] args)
    {

        BitInputStream bits = null;
        CountDisplay cd = new CountDisplay();
        try
        {
            bits = new BitInputStream(
                new FileInputStream(
                    "X:\\Documents\\Spring 2016\\CSE 017\\text1.txt"));
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        cd.initialize(bits);
        cd.showCounts();



    }
}
