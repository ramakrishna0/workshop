package com.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplTest {

    @Mock
    private DataService dataService;
    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findGreatestFromAllData_oneElement() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(35, someBusiness.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_basicScenario() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{25, 15, 5});
        assertEquals(25, someBusiness.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_emptyArray() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, someBusiness.findGreatestFromAllData());
    }

}
