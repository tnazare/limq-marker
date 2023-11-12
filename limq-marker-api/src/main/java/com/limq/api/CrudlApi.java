package com.limq.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public interface CrudlApi<T> {
    @PostMapping()
    public ResponseEntity<T> create(@RequestBody T object);

    @GetMapping(value = "/{id}")
    public ResponseEntity read(@PathVariable UUID id);

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody T object);

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable UUID id);
    @GetMapping()
    public ResponseEntity<Collection<T>> list();
}
