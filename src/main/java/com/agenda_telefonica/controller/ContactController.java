package com.agenda_telefonica.controller;

import com.agenda_telefonica.dto.ContactCreationDto;
import com.agenda_telefonica.entity.ContactEntity;
import com.agenda_telefonica.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/list")
    public List<ContactEntity> listContacts() {
        return contactService.listContacts();
    }

    @GetMapping("/list-favourites")
    public List<ContactEntity> listFavouriteContacts() {
        return contactService.listFavouriteContacts();
    }

    @GetMapping("/{contactId}/details")
    public ContactEntity getContactDetails(@PathVariable("contactId") UUID contactId) {
        return contactService.getContactDetails(contactId);
    }

    @PostMapping("/add")
    public void addContact(@RequestBody ContactCreationDto contactCreationDto) {
        System.out.println("criando contato");
        contactService.addContact(contactCreationDto);
    }

    @PatchMapping("/add-favourite/{contactId}")
    public void addFavouriteContact(@PathVariable("contactId") UUID contactId) {
        contactService.addFavouriteContact(contactId);
    }

    @PatchMapping("/remove-favourite/{contactId}")
    public void removeFavouriteContact(@PathVariable("contactId") UUID contactId) {
        contactService.removeFavouriteContact(contactId);
    }

    @PatchMapping("/edit/{contactId}")
    public void editContact(
            @PathVariable("contactId") UUID contactId,
            @RequestBody ContactCreationDto contactCreationDto
    ) {
        contactService.editContact(contactId, contactCreationDto);
    }

    @DeleteMapping("/delete/{contactId}")
    public void deleteContact(@PathVariable("contactId") UUID contactId) {
        contactService.deleteContact(contactId);
    }
}
