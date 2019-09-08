package u3e.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * If you create any test class into this package the runner will automatically recognize and run them.
 */
@RunWith(JUnitPlatform.class)
@SelectPackages("u3e.battleship")
public class AllTests { }
