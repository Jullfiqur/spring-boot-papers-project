package com.qa.papers.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The library with this id doesn't exist")
public class LibraryNotFoundException extends EntityNotFoundException {
}
