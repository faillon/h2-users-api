package cl.faillon.h2usersapi.common.dto;

import cl.faillon.h2usersapi.adapter.out.persistence.phone.PhoneEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDTO {
    @NotBlank
    @Min(7)
    private String number;

    @NotBlank
    @Min(1)
    @JsonProperty(value = "citycode")
    private String cityCode;

    @NotBlank
    @Min(2)
    @JsonProperty(value = "contrycode")
    private String contryCode;

    public PhoneDTO(PhoneEntity phoneEntity) {
        this.number = phoneEntity.getNumber();
        this.cityCode = phoneEntity.getCityCode();
        this.contryCode = phoneEntity.getContryCode();
    }
}
