package dev.iCeBULLL.linkshortener.link;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Service
class LinkServiceImpl implements LinkService {

    private final Map<String, LinkDto> repository = new HashMap<>();

    @Override
    public LinkDto createLink(LinkDto dto) throws LinkAlreadyExistsException {
        if (repository.containsKey(dto.id())) {
            throw new LinkAlreadyExistsException(dto.id());
        } else {
            repository.put(dto.id(), dto);
            return dto;
        }
    }

    @Override
    public LinkDto getLink(String id) {
        return repository.get(id);
    }
}
