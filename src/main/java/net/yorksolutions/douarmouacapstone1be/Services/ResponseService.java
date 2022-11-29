package net.yorksolutions.douarmouacapstone1be.Services;

import net.yorksolutions.douarmouacapstone1be.Repositories.ResponseRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    ResponseRepository responseRepository;

    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }
}
