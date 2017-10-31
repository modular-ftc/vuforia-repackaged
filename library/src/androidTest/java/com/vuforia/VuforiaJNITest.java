package com.vuforia;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Mitchell on 10/31/2017.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class VuforiaJNITest {
    @Test
    public void testInitJNI() {
        Vuforia.setInitParameters(null, 0, null);

        assertThat(Vuforia.wasInitializedJava(), is(true));

        Vuforia.init();
    }
}
