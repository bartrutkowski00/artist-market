package domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "userrole")

public class UserroleEntity {
    @Id
    private Long userroleid;
    private String description;

    public UserroleEntity(Long userroleid, String description) {
        this.userroleid = userroleid;
        this.description = description;
    }

    public UserroleEntity() {

    }
}

