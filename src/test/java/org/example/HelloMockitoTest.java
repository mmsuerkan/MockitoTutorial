package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloMockitoTest {
    @Mock
    private PersonRepository personRepository;

    @Mock
    private TranslationService translationService;

    @InjectMocks
    private HelloMockito helloMockito;

    @Test
    void greetAPersonThatExists(){

        when(personRepository.findById(anyLong())).thenReturn(Optional.of(new Person(1,"John", "Doe", LocalDate.of(2000, 1, 1))));
        when(translationService.translate("Hello, Grace, from Mockito!", "en", "en")).thenReturn("Hello, Grace, from Mockito!");

        String greeting = helloMockito.greeting(1L, "en", "en");
        assertEquals("Hello, Grace, from Mockito!", greeting);

        InOrder inOrder = Mockito.inOrder(personRepository, translationService);
        inOrder.verify(personRepository).findById(anyLong());
        inOrder.verify(translationService).translate("Hello, Grace, from Mockito!", "en", "en");
    }


}