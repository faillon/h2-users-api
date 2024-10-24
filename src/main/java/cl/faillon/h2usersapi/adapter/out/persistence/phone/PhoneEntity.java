package cl.faillon.h2usersapi.adapter.out.persistence.phone;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phones")
public class PhoneEntity implements Serializable {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name="phone_id")
    private UUID id;

    @Column(name="number", nullable = false)
    private String number;

    @Column(name="city_code", nullable = false)
    @JsonProperty(value = "citycode")
    private String cityCode;

    @Column(name="country_code", nullable = false)
    @JsonProperty(value = "contrycode")
    private String contryCode;

    @Column(name="user_id")
    private UUID userId;
}
