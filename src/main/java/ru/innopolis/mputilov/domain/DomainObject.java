package ru.innopolis.mputilov.domain;

/**
 * Domain object for all domains objects that must be saved in db
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class DomainObject {
    private String id;

    public DomainObject(String id) {
        this.id = id;
    }

    public DomainObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
