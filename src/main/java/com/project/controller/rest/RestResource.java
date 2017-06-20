package com.project.controller.rest;

import com.project.model.transer.BaseResponse;
import com.project.model.transer.ObjectRequest;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by user on 1/4/2017.
 */

@RestController
@RequestMapping("/home")
public class RestResource {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public BaseResponse index() {
        return new BaseResponse();
    }


    @RequestMapping(
            value = {"/home"},
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public BaseResponse home(@RequestBody ObjectRequest request) {

        return new BaseResponse();
    }

    @RequestMapping(
            value = {"/queryParams"},
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )

    public BaseResponse queryParams( @RequestHeader("id") Long id,
                                    @RequestHeader("name") String name) {
        System.err.println("hello: " + (2 * id));
        return new BaseResponse();
    }

    @RequestMapping(
            value = {"/form1"},
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public BaseResponse formData(@RequestBody MultiValueMap params) {
        System.err.println("hello: " + params);
        return new BaseResponse();
    }

    @RequestMapping(
            value = {"/form2"},
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public BaseResponse formData(@RequestParam Long id, @RequestParam String name) {
        System.err.println("hello: " + name);
        return new BaseResponse();
    }

    @RequestMapping(
            value = {"/form3"},
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public BaseResponse formData(ObjectRequest request) {
        System.err.println("hello: " + request.getName());
        return new BaseResponse();
    }

}
