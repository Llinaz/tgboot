package ru.skillfactorydemo.tgbot.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void testRepo() {
        List<Spend> found = spendRepository.findAll();
        int importInsertCount = found.size();
        int maxTestStep = 10;
        if (maxTestStep > importInsertCount) {
            for (int i = 0; i < (maxTestStep - importInsertCount); i++, spendRepository.save(new Spend()));
        }
        found = spendRepository.findAll();
        assertEquals(10, found.size());
    }
}
