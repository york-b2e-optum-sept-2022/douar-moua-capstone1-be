package net.yorksolutions.douarmouacapstone1be.Services;

import net.yorksolutions.douarmouacapstone1be.DTOs.NewResponseRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Response;
import net.yorksolutions.douarmouacapstone1be.Repositories.ResponseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ResponseService {

    ResponseRepository responseRepository;

    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Response addResponse(NewResponseRequestDTO requestDTO){
        try {
            return this.responseRepository.save(
                    new Response(requestDTO.answer, requestDTO.surveyId, requestDTO.surveyTitle, requestDTO.questionId, requestDTO.question)
            );
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


}
