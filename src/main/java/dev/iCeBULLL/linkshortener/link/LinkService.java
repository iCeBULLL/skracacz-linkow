package dev.iCeBULLL.linkshortener.link;

public interface LinkService {
    LinkDto createLink(LinkDto toDto);

    LinkDto getLink(String id);
}
