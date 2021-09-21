package it.fabrick.banking.web.rest;

import it.fabrick.banking.service.dto.GenericResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus status = clientHttpResponse.getStatusCode();
        return status.is4xxClientError() || status.is5xxServerError();
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        String responseAsString = toString(response.getBody());
        log.error("Request handle error, HttpMethod: {}, ResponseBody: {}", method, responseAsString);
        handleStatusException(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String responseAsString = toString(response.getBody());
        log.error("Request handle error, ResponseBody: {}", responseAsString);
        handleStatusException(response);
    }

    private void handleStatusException(ClientHttpResponse response) throws IOException {
        log.error("Request STATUS CODE: {}", response.getStatusCode());
        response.getBody();
        if (response.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            //
        } else if (response.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new NotFoundException();
            } else if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
                throw new ForbiddenException();
            } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new BadRequestException();
            }
        }
    }

    String toString(InputStream inputStream) {
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
