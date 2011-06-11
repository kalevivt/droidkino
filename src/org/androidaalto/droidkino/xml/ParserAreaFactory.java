package org.androidaalto.droidkino.xml;

import org.androidaalto.droidkino.xml.sax.FinnkinoAreaSAXParser;

public class ParserAreaFactory {
    public static AreaParser getParser() {
        return new FinnkinoAreaSAXParser();
    }
}
