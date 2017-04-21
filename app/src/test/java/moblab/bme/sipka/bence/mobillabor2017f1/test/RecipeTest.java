package moblab.bme.sipka.bence.mobillabor2017f1.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.BuildConfig;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainScreen;
import moblab.bme.sipka.bence.mobillabor2017f1.utils.RobolectricDaggerTestRunner;

import static moblab.bme.sipka.bence.mobillabor2017f1.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeTest {

    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void testRecipeGroups() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getRecipeGroups();

        ArgumentCaptor<List> groupsCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen, times(1)).showRecipeGroups(groupsCaptor.capture());

        List<RecipeGroup> capturedTodos = groupsCaptor.getValue();
        assertEquals("1", capturedTodos.get(0).getId());
        assertEquals("2", capturedTodos.get(1).getId());
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}