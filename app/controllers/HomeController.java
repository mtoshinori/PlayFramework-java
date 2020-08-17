package controllers;


import models.*;
import java.util.*;
import javax.inject.*;
import play.mvc.*;
import play.data.*;
import io.ebean.*;


public class HomeController extends Controller {
    private final Form<PersonForm> personform;
    private final FormFactory formFactory;
    private final PersonRepository repo;


    @Inject
    public HomeController(FormFactory formFactory,
            PersonRepository personRepository) {
        this.formFactory = formFactory;
        this.personform = formFactory.form(PersonForm.class);
        this.repo = personRepository;
    }

    public Result index() {
        return ok(views.html.index.render(
            "People List.",
            PersonEntity.db().find(PersonEntity.class).findList()
        ));
    }

    public Result show(int id) {
        return ok(views.html.show.render(
                "Show Person",
                repo.get(id), id
            ));
    }

    public Result add() {
        return ok(views.html.add.render(
            "フォームに入力して下さい。",
            personform
        ));
    }

    public Result create() {
        PersonEntity person = formFactory.form(PersonEntity.class)
            .bindFromRequest().get();
        repo.add(person);
        return redirect(routes.HomeController.index());
    }

    public Result edit(int id) {
        PersonEntity person = repo.get(id);
        PersonForm form = new PersonForm(id);
        form.setName(person.getName());
        form.setMail(person.getMail());
        form.setTel(person.getTel());
        Form<PersonForm> formdata = personform.fill(form);
        return ok(views.html.edit.render(
            "Edit Person",
            formdata, id
        ));
    }

    public Result update(int id) {
        PersonForm form = formFactory.form(PersonForm.class)
            .bindFromRequest().get();
        PersonEntity person = new PersonEntity(id,
            form.getName(), form.getMail(), form.getTel());
        repo.update(person);
        return redirect(routes.HomeController.index());
    }

    public Result delete(int id) {
        return ok(views.html.delete.render(
                "Delete Person",
                repo.get(id), id
        ));
    }


    public Result remove(int id) {
        repo.delete(id);
        return redirect(routes.HomeController.index());
    }

}