package com.goit.url.V2;

import com.goit.auth.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UrlCrudService {
    UrlDto createURL(UrlDto urlDto);

    Optional<UrlDto> getURLById(Long id);
    Optional<UrlDto> getURLByShortId(String shortId);
    Optional<UrlDto> getURLByShortIdAndUser(String shortId, User user);

    List<UrlDto> getAllByUserId();
    List<UrlDto> getAllActiveByUserId();
    void increaseClicksCount(String shortId);
    void deleteByShortIdAndUser(String shortId, User user);
}
