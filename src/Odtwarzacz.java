/**
 * Created by Wojtek on 2015-11-22.
 */
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Odtwarzacz
{
    FileInputStream FIS;
    BufferedInputStream BIS;

    public Player player;
    public long location;
    public long dlugoscutworu;
    public String sciezkautworu;

    public void Stop()
    {
        if(player!=null)
        {
            player.close();
            location=0;
            dlugoscutworu=0;
        }
    }

    public void Pause()
    {
        if(player!=null)
        {
            try
            {
                location=FIS.available();
                player.close();
            }
            catch(IOException ex)
            {

            }
        }
    }

    public void Graj(String sciezka)
    {
        try
        {
            FIS=new FileInputStream(sciezka);
            BIS=new BufferedInputStream(FIS);
            player=new Player(BIS);

            dlugoscutworu=FIS.available();
            sciezkautworu=sciezka + "";

        }
        catch(FileNotFoundException | JavaLayerException ex)
        {

        }
        catch(IOException ex)
        {

        }
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    player.play();
                }
                catch(JavaLayerException ex)
                {
                }
            }
        }.start();
    }

    public void Wznow()
    {
        try
        {
            FIS=new FileInputStream(sciezkautworu);
            BIS=new BufferedInputStream(FIS);
            player=new Player(BIS);
            FIS.skip(dlugoscutworu-location);
        }

        catch(FileNotFoundException | JavaLayerException ex)
        {

        }
        catch(IOException ex)
        {

        }
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    player.play();
                }
                catch(JavaLayerException ex)
                {
                }
            }
        }.start();
    }
}
