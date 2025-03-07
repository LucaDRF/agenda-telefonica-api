package com.agenda_telefonica.dto;

import com.agenda_telefonica.entity.ContactEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactCreationDto {
    private String name;
    private String email;
    private String cellPhone;
    private String telephone;

    public static ContactEntity toEntity(ContactCreationDto dto) {
        return new ModelMapper().map(dto, ContactEntity.class);
    }
}
