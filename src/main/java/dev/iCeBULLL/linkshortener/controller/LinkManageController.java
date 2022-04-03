package dev.iCeBULLL.linkshortener.controller;


import dev.iCeBULLL.linkshortener.link.LinkAlreadyExistsException;
import dev.iCeBULLL.linkshortener.link.LinkDto;
import dev.iCeBULLL.linkshortener.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/links")
class LinkManageController {

    private final LinkService service;

    @Autowired
    LinkManageController(LinkService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createLink(@RequestBody CreateLinkDto link) {
        try {
            LinkDto linkDto = link.toDto();
            return ResponseEntity.
                    created(URI.create(linkDto.getShortenedLink())).
                    body(service.createLink(linkDto));
        } catch (LinkAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).
                    body(new ExceptionResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}/{email}")
    ResponseEntity<?> deleteLink(String id, String email) {
        throw new RuntimeException("Zepsute");
    }
}