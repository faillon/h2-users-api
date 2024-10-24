package cl.faillon.h2usersapi.common.dto;

import cl.faillon.h2usersapi.adapter.out.persistence.phone.PhoneEntity;
import cl.faillon.h2usersapi.adapter.out.persistence.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones = new ArrayList<>();
    private Date created;
    private Date modified;
    @JsonProperty(value = "last_login", access = JsonProperty.Access.READ_ONLY)
    private Date lastLogin;
    private String token;
    @JsonProperty(value = "isactive", access = JsonProperty.Access.READ_ONLY)
    private Boolean isActive;

    private static Function<PhoneEntity, PhoneDTO> mapper = PhoneDTO::new;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.phones = userEntity.getPhones().stream().map(mapper).toList();
        this.created = userEntity.getCreated();
        this.modified = userEntity.getModified();
        this.lastLogin = userEntity.getLastLogin();
        this.token = userEntity.getToken();
        this.isActive = userEntity.getIsActive();
    }
}
