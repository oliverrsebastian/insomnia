package com.blibli.future.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "todoItem")
public class Todo extends AuditModel{

    @Id
    @GeneratedValue(generator = "item_generator")
    @SequenceGenerator(
            name = "item_generator",
            sequenceName = "item_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String itemDescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Long getItemId() {
        return id;
    }

    public void setItemId(Long ItemId) {
        this.id = ItemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
