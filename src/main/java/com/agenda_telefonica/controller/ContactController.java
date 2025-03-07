package com.agenda_telefonica.controller;

import com.agenda_telefonica.dto.ContactCreationDto;
import com.agenda_telefonica.entity.ContactEntity;
import com.agenda_telefonica.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController("/contacts")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/list")
    public ContactEntity[] listContacts() {
        return contactService.listContacts();
    }

    @GetMapping("/list-favourites")
    public ContactEntity[] listFavouriteContacts() {
        return contactService.listFavouriteContacts();
    }

    @GetMapping("/details/{contactId}")
    public ContactEntity getContactDetails(@PathVariable("chairId") UUID contactId) {
        return contactService.getContactDetails(contactId);
    }

    @PostMapping("/add")
    public void addContact(@RequestBody ContactCreationDto contactCreationDto) {
        contactService.addContact(contactCreationDto);
    }

    @PutMapping("/add-favourite/{contactId}")
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
