package com.luv2tech.util.service;

import org.springframework.validation.BindingResult;

import java.util.Map;

public interface ErrorCollector {

    Map<String, String> getErrorResponses(BindingResult result);
}
