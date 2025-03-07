package com.agenda_telefonica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
@SQLDelete(sql = "UPDATE contact_entity SET is_deleted = true WHERE id=?")
@Data
@Entity
public class ContactEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @NotNull(message = "Nome é obrigatório")
    @Length(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull(message = "Email é obrigatório")
    @Length(max = 255, message = "Email deve ter no máximo 255 caracteres")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Celular é obrigatório")
    @Length(max = 11, message = "Celular deve ter no máximo 11 caracteres")
    @Column(length = 11, nullable = false)
    private String cellPhone;

    @Length(max = 10, message = "Telefone deve ter no máximo 10 caracteres")
    @Column(length = 10)
    private String telephone;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isFavorite = false;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;

    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt = LocalDateTime.now();
}
