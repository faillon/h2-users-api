package cl.faillon.h2usersapi.domain;


import cl.faillon.h2usersapi.common.dto.PhoneDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    //Ejemplo sencillo clase dominio
    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private String token;
    private Boolean isActive;

    public int getNumberOfPhones(){
        return this.getPhones().size();
    }

}
