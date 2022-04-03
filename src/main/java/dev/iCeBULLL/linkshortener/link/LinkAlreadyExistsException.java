package dev.iCeBULLL.linkshortener.link;


public class LinkAlreadyExistsException extends RuntimeException {

    public LinkAlreadyExistsException(String id) {
        super("Link o id " + id + " już powstał");

    }
}
