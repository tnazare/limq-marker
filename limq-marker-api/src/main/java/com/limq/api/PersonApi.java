package com.limq.api;

import com.limq.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "persons")
public interface PersonApi extends CrudlApi<Person> {
}
