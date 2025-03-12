package com.agenda_telefonica.repository;

import com.agenda_telefonica.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ContactRepository  extends JpaRepository<ContactEntity, UUID> {
    List<ContactEntity> findAllByIsFavoriteTrue();

    ContactEntity findByEmail(String email);

    @Query("SELECT contact FROM ContactEntity contact WHERE contact.cellPhone = :phone")
    ContactEntity findExistingPhone(String phone);

    @Query("SELECT contact FROM ContactEntity contact WHERE contact.id != :id AND contact.cellPhone = :phone")
    ContactEntity findExistingPhoneById(UUID id, String phone);
}
