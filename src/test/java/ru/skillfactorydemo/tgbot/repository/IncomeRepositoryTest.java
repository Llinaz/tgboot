package ru.skillfactorydemo.tgbot.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Income;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class IncomeRepositoryTest {

    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void testRepo() {
        List<Income> found = incomeRepository.findAll();
        int importInsertCount = found.size();
        int maxTestStep = 10;
        if (maxTestStep > importInsertCount) {
            for (int i = 0; i < (maxTestStep - importInsertCount); i++, incomeRepository.save(new Income())) ;
        }
        found = incomeRepository.findAll();
        assertEquals(10, found.size());
    }


}
