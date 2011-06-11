package org.androidaalto.droidkino.xml;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.androidaalto.droidkino.AreaInfo;

public class BaseFinnkinoAreaParser implements AreaParser {
    protected static final String ID = "ID";
    protected static final String NAME = "NAME";
    protected final URL finnikoUrl;
    public BaseFinnkinoAreaParser() {
        try {
            this.finnikoUrl = new URL("http://www.finnkino.fi/xml/TheatreAreas/");
        } catch (MalformedURLException  e) {
            throw new RuntimeException();
        }
    }
    
    /***
     * get an InputStream object to XMl of Finniko.fi website
     * @return
     */
    protected InputStream getInputStream() {
        try {
            return finnikoUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AreaInfo> parse() {
        // TODO Auto-generated method stub
        return null;
    }
}
