package net.yorksolutions.douarmouacapstone1be.Controllers;

import net.yorksolutions.douarmouacapstone1be.DTOs.NewResponseRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Response;
import net.yorksolutions.douarmouacapstone1be.Services.ResponseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/response")
@CrossOrigin
public class ResponseController {

    ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public Response addResponse(@RequestBody NewResponseRequestDTO requestDTO){
        return this.responseService.addResponse(requestDTO);
    }

    @PostMapping("/add-responses")
    public Iterable<Response> addResponses(@RequestBody Iterable<Response> responses){
        return this.responseService.addResponses(responses);
    }

    @GetMapping("/all-responses")
    public Iterable<Response> getAllResponses(){
        return this.responseService.getAllResponses();
    }

    @GetMapping
    public Response getResponse(@RequestParam Long responseId){
        return this.responseService.getResponse(responseId);
    }

    @GetMapping("/instance")
    public Iterable<Response> getAllResponseByInstance(@RequestParam Long instance){
        return this.responseService.getAllResponseByInstance(instance);
    }
}
