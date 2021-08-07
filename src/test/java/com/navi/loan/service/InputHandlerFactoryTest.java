package com.navi.loan.service;

import com.navi.loan.service.impl.TxtFileInputHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InputHandlerFactoryTest {

    @Test
    public void getTxtInputHandlerTest() throws Exception {
        InputHandlerFactory inputHandlerFactory = new InputHandlerFactory();
        InputHandler inputHandler = inputHandlerFactory.getHandler("txtFileHandler");
        Assert.assertTrue(inputHandler instanceof TxtFileInputHandler);
    }

    @Test(expected = Exception.class)
    public void getUnknownInputHandlerTest() throws Exception {
        InputHandlerFactory inputHandlerFactory = new InputHandlerFactory();
        InputHandler inputHandler = inputHandlerFactory.getHandler("abc");
    }
}
