package suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import tests.TestAddressBook;
import tests.TestProject;


@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Egroupware_tests")
@SelectPackages("test")
@SelectClasses( {TestAddressBook.class,TestProject.class} )
@IncludeTags("Para_Suite_AmbienteTest")
public class TestSuite {


}
