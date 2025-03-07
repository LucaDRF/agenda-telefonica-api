package com.agenda_telefonica.repository;

import com.agenda_telefonica.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository  extends JpaRepository<ContactEntity, UUID> {
}
