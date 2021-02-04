package com.kanban.demo.candidate;

import com.kanban.demo.states.States;

public class Candidate {
    private int id;
    private String name;
    private String education;
    private String contact;
    private States states;

    public Candidate(int id,String name,String Education,String contact,States states){
        this.id = id;
        this.name = name;
        this.education = education;
        this.contact = contact;
        this.states = states;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }
}
