package cl.faillon.h2usersapi.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;
    private Date created;
    private Date modified;
    @JsonProperty(value = "last_login", access = JsonProperty.Access.READ_ONLY)
    private Date lastLogin;
    private String token;
    @JsonProperty(value = "isactive", access = JsonProperty.Access.READ_ONLY)
    private Boolean isActive;
}
