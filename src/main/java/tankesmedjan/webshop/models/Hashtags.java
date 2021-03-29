package tankesmedjan.webshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class Hashtags {
    @Id
    @Column(length = 100)
    private String Hashtag;
}
