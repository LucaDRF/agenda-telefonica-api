package com.agenda_telefonica.service;

import com.agenda_telefonica.dto.ContactCreationDto;
import com.agenda_telefonica.entity.ContactEntity;
import com.agenda_telefonica.error.ContactNotFoundError;
import com.agenda_telefonica.error.InvalidInputError;
import com.agenda_telefonica.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public List<ContactEntity> listContacts() {
        return contactRepository.findAll();
    }

    public List<ContactEntity> listFavouriteContacts() {
        return contactRepository.findAllByIsFavoriteTrue();
    }

    public ContactEntity getContactDetails(UUID contactId) {
        return contactRepository.findById(contactId).orElse(null);
    }

    public void addContact(ContactCreationDto contactCreationDto) {
        validatePhone(contactCreationDto.getCellPhone());

        ContactEntity contactEntity = ContactCreationDto.toEntity(contactCreationDto);

        contactRepository.save(contactEntity);
    }

    public void addFavouriteContact(UUID contactId) {
        ContactEntity contactEntity = contactRepository.findById(contactId).orElseThrow(
                () -> new ContactNotFoundError("Contato não encontrado")
        );

        contactEntity.setFavorite(true);
        contactRepository.save(contactEntity);
    }

    public void removeFavouriteContact(UUID contactId) {
        ContactEntity contactEntity = contactRepository.findById(contactId).orElseThrow((
                () -> new ContactNotFoundError("Contato não encontrado")
        ));

        contactEntity.setFavorite(false);
        contactRepository.save(contactEntity);
    }

    public void editContact(UUID contactId, ContactCreationDto contactCreationDto) {
        ContactEntity contactEntity = contactRepository.findById(contactId).orElseThrow((
                () -> new ContactNotFoundError("Contato não encontrado")
        ));

        validatePhoneWithId(contactId, contactCreationDto.getCellPhone());

        if (contactCreationDto.getName() != null) {
            contactEntity.setName(contactCreationDto.getName());
        }

        if (contactCreationDto.getEmail() != null) {
            contactEntity.setEmail(contactCreationDto.getEmail());
        }

        if (contactCreationDto.getCellPhone() != null) {
            contactEntity.setCellPhone(contactCreationDto.getCellPhone());
        }

        if (contactCreationDto.getTelephone() != null) {
            contactEntity.setTelephone(contactCreationDto.getTelephone());
        }

        contactRepository.save(contactEntity);
    }

    public void deleteContact(UUID contactId) {
        ContactEntity contactEntity = contactRepository.findById(contactId).orElseThrow((
                () -> new ContactNotFoundError("Contato não encontrado")
        ));

        contactRepository.delete(contactEntity);
    }

    private void validatePhone(String phone) {
        if (contactRepository.findExistingPhone(phone) != null) {
            throw new InvalidInputError("Celular já utilizado");
        }
    }

    private void validatePhoneWithId(UUID id, String phone) {
        if (contactRepository.findExistingPhoneById(id, phone) != null) {
            throw new InvalidInputError("Celular já utilizado");
        }
    }
}
