package org.androidaalto.droidkino;

import java.io.Serializable;

public class AreaInfo implements Serializable {
    private static final long serialVersionUID = 109528203852L;
    private String id;
    private String name;
    
    public AreaInfo() {}
    
    public AreaInfo(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
