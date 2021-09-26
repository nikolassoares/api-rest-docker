package com.enquete.apirest.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long option_id;

    @Column(name = "option_description")
    private String option_description;

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "option_id")
    private List<Vote> votes;

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public long getOption_id() {
        return option_id;
    }

    public void setOption_id(long option_id) {
        this.option_id = option_id;
    }

    public String getOption_description() {
        return option_description;
    }

    public void setOption_description(String option_description) {
        this.option_description = option_description;
    }
}