package cl.faillon.h2usersapi.adapter.out.persistence.user;

import cl.faillon.h2usersapi.adapter.out.persistence.phone.PhoneEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name="user_id")
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH}, orphanRemoval = true)
    private Set<PhoneEntity> phones;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date created;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    private Date modified;

    @LastModifiedDate
    @Column(name = "last_login", nullable = false)
    private Date lastLogin;

    @Column(name = "token")
    private String token;

    @Column(name = "active", nullable = false)
    private Boolean isActive = true;
}
