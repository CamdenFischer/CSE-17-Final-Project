import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Camden Fischer
 * @version Apr 11, 2016
 */
public class CountDisplay
    implements IHuffModel
{
    /**
     * Creating a CharCounter
     */
    ICharCounter        cc = new CharCounter();
    /**
     * Creating a BitInputStream
     */
    private InputStream bits;


    public void initialize(InputStream stream)
    {
        try
        {
            bits = new BitInputStream(
                new FileInputStream(
                    "X:\\Documents\\Spring 2016\\CSE 017\\text1.txt"));
        }
        catch (FileNotFoundException e)
        {

            e.printStackTrace();
        }

    }


    public void showCounts()
    {

        try
        {
            cc.countAll(bits);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 256; i++)
        {
            if (cc.getCount(i) != 0)
            {
                System.out.println((char)i + ": " + cc.getCount(i));
            }
        }

    }


    public void showCodings()
    {
        int count = 0;

        try
        {
            cc.countAll(bits);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < 256; i++)
        {
            if (cc.getCount(i) != 0)
            {
                count++;
            }
        }

        HuffTree[] treeArr = new HuffTree[count];
        int x = 0;
        for (int i = 0; i < 256; i++)   //creating an array of trees that have
                                        //non zero counts
        {
            if (cc.getCount(i) != 0)
            {
                treeArr[x] = new HuffTree((char) i, cc.getCount(i));
            }
        }

        MinHeap heap = new MinHeap(treeArr, count, 255);

    }




    public void write(InputStream stream, File file, boolean force)
    {
        // TODO Auto-generated method stub

    }


    public void uncompress(InputStream in, OutputStream out)
    {
        // TODO Auto-generated method stub

    }

}
