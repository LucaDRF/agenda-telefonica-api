package com.agenda_telefonica.repository;

import com.agenda_telefonica.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository  extends JpaRepository<ContactEntity, UUID> {
    List<ContactEntity> findAllByIsFavoriteTrue();

    ContactEntity findByEmail(String email);
}
