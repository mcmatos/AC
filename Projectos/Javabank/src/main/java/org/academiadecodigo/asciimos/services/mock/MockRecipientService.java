package org.academiadecodigo.asciimos.services.mock;


import org.academiadecodigo.asciimos.model.Recipient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class MockRecipientService extends AbstractMockService<Recipient> {
}
