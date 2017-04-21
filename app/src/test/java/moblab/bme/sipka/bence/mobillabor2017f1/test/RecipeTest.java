package moblab.bme.sipka.bence.mobillabor2017f1.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.BuildConfig;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainScreen;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipePresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipeScreen;
import moblab.bme.sipka.bence.mobillabor2017f1.utils.RobolectricDaggerTestRunner;

import static moblab.bme.sipka.bence.mobillabor2017f1.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeTest {

    private RecipePresenter presenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        presenter = new RecipePresenter();
    }

    @Test
    public void testRecipeGroups() {
        RecipeScreen screen = mock(RecipeScreen.class);
        presenter.attachScreen(screen);
        presenter.getRecipe("11");

        ArgumentCaptor<Recipe> groupsCaptor = ArgumentCaptor.forClass(Recipe.class);
        verify(screen, times(1)).showRecipe(groupsCaptor.capture());

        Recipe recipe = groupsCaptor.getValue();
        assertEquals("11", recipe.getId());
    }

    @After
    public void tearDown() {
        presenter.detachScreen();
    }
}