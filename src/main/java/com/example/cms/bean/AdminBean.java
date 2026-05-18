package com.example.cms.bean;

import com.example.cms.entity.Content;
import com.example.cms.service.ContentService;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AdminBean implements Serializable{
    
    @Inject
    private ContentService service;

    private List<Content> list;
    private Content form = new Content();

    @PostConstruct
    public void init(){
        list = service.findAll();
    }

    public void save(){
        if(form.getId() == null){
            service.save(form);
        } else {
            service.update(form);
        }
        form = new Content();
        list = service.findAll();
    }

    public void edit(Content c){
        this.form = c;
    }

    public void delete(Long id){
        service.delete(id);
        list = service.findAll();
    }

    public List<Content> getList() { return list; }
    public Content getForm() { return form; }
    public void setForm(Content f) { this.form = f; }
}
