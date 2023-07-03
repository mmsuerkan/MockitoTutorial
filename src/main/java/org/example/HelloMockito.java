package org.example;


import java.util.Optional;

public class HelloMockito {

    private String greeting = "Hello, %s, world!";

    private final PersonRepository personRepository;
    private final TranslationService translationService;

    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }


    public String greeting(Long id, String source, String target) {

        Optional<Person> person = personRepository.findById(id);
        String name = person.map(Person::getFirstName).orElse("World");

        return translationService.translate(String.format(greeting, name), source, target);
    }
}
