package ru.gb.homework20240416.service;

import lombok.AllArgsConstructor;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.gb.homework20240416.configuration.RemoteApiConfiguration;
import ru.gb.homework20240416.domain.Characters;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi{

    private final RestTemplate template;

    private final HttpHeaders headers;

    private final RemoteApiConfiguration remoteApiConfiguration;

    @Override
    public Characters getAllCharacters(int page) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(remoteApiConfiguration.getApi())
                .queryParam("page",page)
                .build();
        ResponseEntity<Characters> responce = template.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Characters.class);
        return responce.getBody();
    }
}
