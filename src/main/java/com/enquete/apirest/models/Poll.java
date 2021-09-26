package com.enquete.apirest.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private long poll_id;

    @Column(name = "poll_description")
    private String poll_description;

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "poll_id")
    private List<Options> options;

    public long getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(long poll_id) {
        this.poll_id = poll_id;
    }

    public String getPoll_description() {
        return poll_description;
    }

    public void setPoll_description(String poll_description) {
        this.poll_description = poll_description;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
