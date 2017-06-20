package com.project.model.transer;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JORGE-HP on 17/6/2017.
 */
@XmlRootElement
public class ObjectRequest {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
