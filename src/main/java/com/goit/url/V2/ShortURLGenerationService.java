package com.goit.url.V2;

import com.goit.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortURLGenerationService {

    private final UrlRepository urlRepository;

    @Autowired
    public ShortURLGenerationService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String generateShortURL(User user) {
        Optional<Long> maxIdOptional = urlRepository.getMaxId();
        long maxId = maxIdOptional.orElse(0L) + 1;

        String userHexId = Long.toHexString(user.getId());
        String maxIdHex = Long.toHexString(maxId);

        String shortUrl = userHexId + maxIdHex;

        return shortUrl.replaceAll("^0[xX]+", "");
    }

}