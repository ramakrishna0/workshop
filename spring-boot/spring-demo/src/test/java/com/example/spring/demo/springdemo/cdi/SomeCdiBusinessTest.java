package com.example.spring.demo.springdemo.cdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes = {SpringBasicDemoApplication.class}) // we can use spring context with mockito, but mockito is faster
public class SomeCdiBusinessTest {

//    @Autowired
    @InjectMocks
    private SomeCdiBusiness someCdiBusiness;
    @Mock
    private SomeCdiDAO someCdiDAO;

    @Test
    public void testBasicScenario_FourElements() {
        Mockito.when(someCdiDAO.getData()).thenReturn(new int[] {50, 24, 55, 35} );
        assertEquals(55,someCdiBusiness.findGreatest());
    }

    @Test
    public void testBasicScenario_NoElements() {
        Mockito.when(someCdiDAO.getData()).thenReturn(new int[0]);
        assertEquals(Integer.MIN_VALUE, someCdiBusiness.findGreatest());
    }

}
