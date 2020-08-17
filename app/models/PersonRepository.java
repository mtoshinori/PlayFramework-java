package models;


import java.util.*;
import models.*;
import play.db.ebean.*;
import io.ebean.*;


public class PersonRepository {


    public EbeanServer ebean;
    public static Finder<Integer, PersonEntity> find =
            new Finder<Integer, PersonEntity>(PersonEntity.class);


    public PersonRepository() {
        this.ebean = Ebean.getDefaultServer();
    }

    public List<PersonEntity> list() {
        return find.all();
    }

    public PersonEntity get(int id) {
        return find.byId(id);
    }

    public void add(PersonEntity person) {
        person.save();
    }

    public void update(PersonEntity person) {
        person.update();
    }

    public void delete(int id) {
        find.byId(id).delete();
    }   


    public void delete(PersonEntity person) {
        person.delete();
    }

    public List<PersonEntity> find(String s) {
        return find.query().where()
            .or()
                .ilike("name", "%" + s + "%")
                .ilike("mail", "%" + s + "%")
                .ilike("tel", "%" + s + "%")
            .endOr().findList();
    }

}