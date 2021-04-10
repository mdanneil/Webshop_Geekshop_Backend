package tankesmedjan.webshop.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.hash.Hashing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    public Account(AccountAndCostumerCreationDTO account) {

        String sha256hex = Hashing.sha256()
                .hashString(account.getPassword(), StandardCharsets.UTF_8)
                .toString();

        this.username = account.getUsername();
        this.password = sha256hex;
        this.role = account.getRole();
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String username;
    private String password;
    private String role;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    @JsonIgnore
    private List<ProductRating> productRating = new ArrayList<ProductRating>();

}
